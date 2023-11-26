package com.screenmatch;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import com.screenmatch.models.Movie;

public class Main {
    public static void main(String[] args) {

        var firstMovie = new Movie(null, null, null, 0, false, 0, 0, 0, 0, null);

        var secondMovie = new Movie(null, null, null, 0, false, 0, 0, 0, 0, null);

        var thirdMovie = new Movie(null, null, null, 0, false, 0, 0, 0, 0, null);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(firstMovie);
        movieList.add(secondMovie);
        movieList.add(thirdMovie);

        firstMovie.setName("Super Mario Bros");
        firstMovie.setPlanCategory("Plus");
        firstMovie.setDebutYear(2023);
        firstMovie.setPlanIncluded(true);
        firstMovie.rateTitle(10);

        secondMovie.setName("Dungeons and Dragons: Honor among thieves");
        secondMovie.setPlanCategory("Plus");
        secondMovie.setDebutYear(2023);
        secondMovie.setPlanIncluded(true);
        secondMovie.rateTitle(9);

        thirdMovie.setName("Guardians of the Galaxy pt 3");
        thirdMovie.setPlanCategory("Básico");
        thirdMovie.setDebutYear(2023);
        thirdMovie.setPlanIncluded(true);
        thirdMovie.rateTitle(8);

        var averageNote = 0.0;
        var sum = 0.0;

        firstMovie.rateTitle(9);
        firstMovie.rateTitle(8);
        firstMovie.rateTitle(9);
        firstMovie.rateTitle(9);

        System.out.println("Esse é o Screen Match");

        firstMovie.showCredits();

        firstMovie.planNotification();

        for (double note : firstMovie.getMovieNotes()) {
            if (note > 0) {
                sum += note;
                averageNote = sum / firstMovie.getMovieNotes().size();
            } else {
                System.out.println("Erro");
            }
        }

        AtomicInteger count = new AtomicInteger(0);
        firstMovie.getMovieNotes().forEach(note -> {
            System.out.printf("%s Nota - %s%n", count.incrementAndGet(), note);
        });

        System.out.printf("Nota média do filme: %.1f %n", averageNote);
        System.out.printf("Array de notas: %s%n", (firstMovie.getMovieNotes()).toString());
        System.out.println(movieList.toString());
    }
}
