package org.lesson.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lesson.java.best_of_the_year.model.Movie;
import org.lesson.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class homeController {

    @GetMapping("/")
    public String Home(Model model, @RequestParam(name = "name") String name) {

        model.addAttribute("name", name);
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

        List<Movie> movies = getBestMovies();
        String titoliFilm = "";

        for (int i = 0; i < movies.size(); i++) {
            titoliFilm += movies.get(i).getTitle();
            if (i < movies.size() - 1) {
                titoliFilm += ", ";
            }
        }

        model.addAttribute("listaFilm", titoliFilm);
        return "movies";
    }

    @GetMapping("/songs")
    public String getBestSongs(Model model) {
        List<Song> songs = getBestSongs();
        String titoliSongs = "";

        for (int i = 0; i < songs.size(); i++) {
            titoliSongs += songs.get(i).getTitle();
            if (i < songs.size() - 1) {
                titoliSongs += ", ";
            }
        }
        model.addAttribute("listaSongs", titoliSongs);
        return "songs";
    }

}
