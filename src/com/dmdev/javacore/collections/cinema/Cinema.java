package com.dmdev.javacore.collections.cinema;

import com.dmdev.javacore.collections.cinema.entity.Film;

import java.util.*;

public class Cinema {

    private final Map<Integer, Set<Film>> filmsLibrary;

    public Cinema() {
        this.filmsLibrary = new LinkedHashMap<>();
    }

    public void addFilm(Film film) {
        int year = film.getYear();

        filmsLibrary.putIfAbsent(year, new LinkedHashSet<>());
        Set<Film> filmsOfYear = filmsLibrary.get(year);

        if (filmsOfYear.contains(film)) {
            System.out.println("Film " + film.getId() + " already exists in the cinema");
            return;
        }
        filmsLibrary.get(year).add(film);
    }

    public Set<Film> getFilmsByYear(int year) {
        return filmsLibrary.getOrDefault(year, new LinkedHashSet<>());
    }

    public Set<Film> getFilmsByYearAndMonth(int year, int month) {
        Set<Film> filmsByYearAndMonth = new HashSet<>();
        Set<Film> filmsByYear = filmsLibrary.getOrDefault(year, new LinkedHashSet<>());

        for (Film film : filmsByYear) {
            if (film.getMonth() == month) {
                filmsByYearAndMonth.add(film);
            }
        }

        return filmsByYearAndMonth;
    }

    public Set<Film> getFilmsByGenre(String genre) {
        Set<Film> filmsByGenre = new HashSet<>();

        for (Set<Film> filmsOfYear : filmsLibrary.values()) {
            for (Film film : filmsOfYear) {
                if (film.getGenre().equals(genre)) {
                    filmsByGenre.add(film);
                }
            }
        }

        return filmsByGenre;
    }

    public List<Film> getTop10FilmsByRatingDescending() {
        List<Film> allFilms = new ArrayList<>();

        for (Set<Film> filmsOfYear : filmsLibrary.values()) {
            allFilms.addAll(filmsOfYear);
        }

        allFilms.sort(new Comparator<Film>() {
            @Override
            public int compare(Film film, Film film1) {
                return Double.compare(film1.getRating(), film.getRating());
            }
        });

        return allFilms.subList(0, Math.min(10, allFilms.size()));
    }
}
