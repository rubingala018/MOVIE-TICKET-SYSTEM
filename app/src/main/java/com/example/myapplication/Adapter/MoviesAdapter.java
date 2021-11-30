package com.example.myapplication.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Movies;
import com.example.myapplication.R;

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
         View itemsView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movies, parent, false);

        return new vieholder(itemsView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.vieholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class vieholder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView title;

        public vieholder(@NonNull View itemView)
        {
            super(itemView);
            picture= itemView.findViewById(R.id.movie_photo);
            title= itemView.findViewById(R.id.title_id);

        }
    }
}
