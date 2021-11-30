package com.example.myapplication.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Movies;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.vieholder> {
    Context context;
    List<Movies> moviesList;

    public MoviesAdapter(Context context,List<Movies> moviesList){
        this.context=context;
        this.moviesList=moviesList;
    }

    @NonNull
    @Override
    public MoviesAdapter.vieholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.vieholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class vieholder extends RecyclerView.ViewHolder {
        public vieholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
