package com.academy.fundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.academy.fundamentals.models.Movie;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements OnClickMovieListener {

    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_movies = findViewById(R.id.rv_movie);
        rv_movies.setLayoutManager(new LinearLayoutManager(this));

        loadMovies();

        rv_movies.setAdapter(new MoviesAdapter(movies, this,this));
    }

    private void loadMovies() {
        movies = new ArrayList<>();

        movies.add(new Movie(
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                R.drawable.the_shawshank_redemption
        ));

        movies.add(new Movie(
                "The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                R.drawable.the_godfather
        ));

        movies.add(new Movie(
                "The Godfather: Part II",
                "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
                R.drawable.the_godfather_part_ii
        ));

        movies.add(new Movie(
                "The Dark Knight",
                "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                R.drawable.the_dark_knight
        ));

        movies.add(new Movie(
                "12 Angry Men",
                "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.",
                R.drawable.twelve_angry_men
        ));

        movies.add(new Movie(
                "Schindler's List",
                "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazi Germans.",
                R.drawable.schindlers_list
        ));

        movies.add(new Movie(
                "The Lord of the Rings: The Return of the King",
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                R.drawable.the_lord_of_the_rings_the_return_of_the_king
        ));

        movies.add(new Movie(
                "Pulp Fiction",
                "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                R.drawable.pulp_fiction
        ));

        movies.add(new Movie(
                "Il buono, il brutto, il cattivo",
                "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.",
                R.drawable.il_buono_il_brutto_il_cattivo
        ));

        movies.add(new Movie(
                getString(R.string.infinity_war_title),
                getString(R.string.infinity_war_overview),
                R.drawable.infinity_war_main
        ));

    }

    @Override
    public void onMovieClick(int position) {
        if (position < 0 || position >= movies.size()) return;
        Movie movie = movies.get(position);
        if (movie == null || TextUtils.isEmpty(movie.getTitle())) return;
        Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
