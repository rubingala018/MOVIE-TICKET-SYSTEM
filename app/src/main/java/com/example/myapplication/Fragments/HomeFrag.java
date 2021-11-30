package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.MoviesAdapter;
import com.example.myapplication.HomePageActivity;
import com.example.myapplication.Models.Movies;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFrag extends Fragment {
    String url;
    RequestQueue requestQueue;
    List<Movies> movielist;
    MoviesAdapter moviesAdapter;

    FragmentHomeBinding binding;

    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater,container,false);

        movielist=new ArrayList<>();

        url = "https://api.themoviedb.org/3/trending/all/day?api_key=955d6646ad9409945b7d0e763d680f76";
        requestQueue = Volley.newRequestQueue(getContext());
        getMovies();

        return binding.getRoot();
    }
    private void getMovies() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String title = obj.getString("name");
                        String lang = obj.getString("vicinity");
                        String photo = obj.getString("vicinity");
                        String rating = obj.getString("vicinity");

                        movielist.add(new Movies(title,lang,photo,rating));
                    }
                    moviesAdapter = new MoviesAdapter(getContext(), movielist);
                    binding.movierecycler.setAdapter(moviesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }
}