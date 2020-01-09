package com.example.springbootfilmscrud.controller;

import com.example.springbootfilmscrud.entity.Film;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/films")
public class FilmsController {
    private ArrayList<Film> films = new ArrayList<>();

    public FilmsController() {
        films.add(new Film(1L,"Titanic", 1997));
        films.add(new Film(2L,"Pulp Fiction", 1995));
    }

    @GetMapping("/all")
    public ArrayList<Film> getAll() {
        return films;
    }

    @GetMapping
    public Film getById(@RequestParam Long index) {
        return films.get(index.intValue());
    }

    @PostMapping
    public boolean addFilm(@RequestBody Film film) {
        return films.add(film);
    }

    @PutMapping
    public Film updateVideo(@RequestBody Film film) {
        return films.set((film.getId().intValue() - 1) ,film);
    }

    @DeleteMapping
    public Film deleteVideo(@RequestParam Long index) {
        return films.remove(index.intValue());
    }
}
