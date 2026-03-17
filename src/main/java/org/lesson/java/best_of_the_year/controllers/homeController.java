package org.lesson.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lesson.java.best_of_the_year.model.Movie;
import org.lesson.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class homeController {

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Titanic"));
        movies.add(new Movie(2, "Star Wars"));
        movies.add(new Movie(3, "Pulp Fiction"));
        movies.add(new Movie(4, "The Wolf of Wallstrett"));

        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(0, "Godzilla"));
        songs.add(new Song(1, "Jungle"));
        songs.add(new Song(2, "Runaway"));
        songs.add(new Song(3, "DtMF"));

        return songs;

    }

    @GetMapping("/movies")
    public String getBestMovies(Model model) {
        model.addAttribute("listaFilm", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String getBestSongs(Model model) {

        model.addAttribute("listaSongs", getBestSongs());
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String singleMovie(@PathVariable("id") int movieId, Model model) {

        List<Movie> movies = getBestMovies();
        Movie movieFound = null;

        for (Movie m : movies) {
            if (m.getId() == movieId) {
                movieFound = m;
            }
        }
        model.addAttribute("SingleMovie", movieFound);

        return "movieDetail";

    }

    @GetMapping("/songs/{id}")
    public String singleSong(@PathVariable("id") int songId, Model model) {

        List<Song> songs = getBestSongs();
        Song songFound = null;

        for (Song s : songs) {
            if (s.getId() == songId) {
                songFound = s;
            }
        }
        model.addAttribute("SingleSong", songFound);

        return "songDetail";
    }

}
