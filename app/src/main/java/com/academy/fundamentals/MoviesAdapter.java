package com.academy.fundamentals;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.academy.fundamentals.models.Movie;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private ArrayList<Movie> mMovies;
    private LayoutInflater mLayoutInflater;
    private OnClickMovieListener mListener;

    public MoviesAdapter(ArrayList<Movie> movies, OnClickMovieListener listener, Context context) {
        this.mMovies = movies;
        mListener = listener;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.movie, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_title;
        private TextView tv_overview;
        private ImageView iv_image;

        MovieHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.movie_row_title);
            tv_overview = itemView.findViewById(R.id.movie_row_overview);
            iv_image = itemView.findViewById(R.id.movie_row_image);
            itemView.setOnClickListener(this);
        }

        void bind(Movie movie) {
            tv_title.setText(movie.getTitle());
            tv_overview.setText(movie.getOverviews());
            iv_image.setImageResource(movie.getImage_id());
        }


        @Override
        public void onClick(View view) {
            if (mListener == null) return;
            mListener.onMovieClick(getAdapterPosition());
        }
    }
}
