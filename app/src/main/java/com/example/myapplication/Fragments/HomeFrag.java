package com.example.myapplication.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
    private ArrayList<Movies> movielist;
    private MoviesAdapter moviesAdapter;
    Context context;

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
                    JSONArray jsonArray=response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String title="";
                        JSONObject obj = jsonArray.getJSONObject(i);
                        if (obj.has("original_title")) {
                            title = obj.getString("original_title");
                        }
                        //String lang = obj.getString("original_language");
                        //String photo = obj.getString("poster_path");
                        //String rating = obj.getString("vote_average");
                        String lang="",photo="",rating="";
                        movielist.add(new Movies(title,lang,photo,rating));
                    }
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
                    binding.movierecycler.setLayoutManager(linearLayoutManager);
                    moviesAdapter = new MoviesAdapter(context, movielist);
                    binding.movierecycler.setAdapter(moviesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("er", "Error" + error.getMessage());
            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }
}