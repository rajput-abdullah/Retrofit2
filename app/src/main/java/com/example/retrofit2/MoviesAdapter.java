package com.example.retrofit2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MoviesAdapter(Context context, List<Movie> movies){
        this.movies = movies;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title, director, description;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            director = itemView.findViewById(R.id.director);
            description = itemView.findViewById(R.id.description);
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.director.setText(movie.getDirector());
        holder.description.setText(movie.getDescription());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}