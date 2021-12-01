package com.example.myapplication.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Fragments.HomeFrag;
import com.example.myapplication.HomePageActivity;
import com.example.myapplication.Models.Movies;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.viewholder> {
    Context con;
    ArrayList<Movies> moviesList;

    public MoviesAdapter(Context context, ArrayList<Movies> moviesList) {
        this.con = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MoviesAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemsView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movies, parent, false);

        return new viewholder(itemsView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.viewholder holder, int position) {
        con=holder.itemView.getContext();
        Movies movies = moviesList.get(position);
        holder.title.setText(movies.getTitle());
        Glide.with(con).load(movies.getPhoto()).into(holder.picture);
        holder.rating.setText(movies.getRating());


        DisplayMetrics lDisplayMetrics = con.getResources().getDisplayMetrics();
        int widthPixels = lDisplayMetrics.widthPixels;

        View view = holder.cardView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (widthPixels/2.3);
        view.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView title,rating;
        CardView cardView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.movie_photo);
            title = itemView.findViewById(R.id.title_id);
            cardView=itemView.findViewById(R.id.card);
            rating=itemView.findViewById(R.id.ratings);

        }
    }
}
