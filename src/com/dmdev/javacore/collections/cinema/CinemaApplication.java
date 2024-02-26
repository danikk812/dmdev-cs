package com.dmdev.javacore.collections.cinema;

import com.dmdev.javacore.collections.cinema.entity.Film;

public class CinemaApplication {

    public static void main(String[] args) {

        Cinema cinema = new Cinema();


        cinema.addFilm(new Film(1, 2021, 5, "Horror", 8.6));
        cinema.addFilm(new Film(2, 2019, 6, "Action", 9.0));
        cinema.addFilm(new Film(3, 2021, 5, "Action", 7.7));
        cinema.addFilm(new Film(4, 2021, 7, "Comedy", 8.1));
        cinema.addFilm(new Film(4, 2023, 8, "Comedy", 6.6));


        System.out.println("Films in 2021: " + cinema.getFilmsByYear(2021));
        System.out.println("_______________________________________________________________");
        System.out.println("Comedy films: " + cinema.getFilmsByGenre("Comedy"));
        System.out.println("_______________________________________________________________");
        System.out.println("Films in May 2021: " + cinema.getFilmsByYearAndMonth(2021, 5));
        System.out.println("_______________________________________________________________");
        System.out.println("Top 10 Films by rating: " + cinema.getTop10FilmsByRatingDescending());
    }
}
