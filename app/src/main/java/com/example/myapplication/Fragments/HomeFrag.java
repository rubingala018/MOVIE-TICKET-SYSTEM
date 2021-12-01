package com.example.myapplication.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
                        String title="",photo="",lang="",rating="",release_date="",overview="";
                        JSONObject obj = jsonArray.getJSONObject(i);
                        if (obj.has("title")) {
                            title = obj.getString("title");
                        }
                        else if(obj.has("original_title")){
                            title = obj.getString("original_title");
                        }
                        if (obj.has("poster_path")) {
                            photo="https://image.tmdb.org/t/p/original"+obj.getString("poster_path");
                        }
                        else {
                            photo=null;
                        }
                        if (obj.has("vote_average")) {
                            rating = obj.getString("vote_average");
                        }
                        else {
                            rating = "N/A";
                        }
                        if(obj.has("release_date")) {
                            release_date = obj.getString("release_date");
                        }
                        if(obj.has("original_language")){
                            lang=obj.getString("original_language");
                        }
                        if(obj.has("overview")){
                            overview=obj.getString("overview");
                        }

                        movielist.add(new Movies(title,lang,photo,rating,release_date,overview));
                    }
                    moviesAdapter = new MoviesAdapter(context, movielist);
                    binding.movierecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
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