package com.screenmatch.models;

import java.util.ArrayList;

public class Movie extends Title {

    public Movie(String name, String type, String planCategory, int debutYear, boolean planIncluded, double review,
            double reviewNoteSum, int totalReviews,
            int durationInMinutes, ArrayList<Double> movieNotes) {
        super(name, planCategory, debutYear, type, planIncluded, review, reviewNoteSum, totalReviews, durationInMinutes,
                movieNotes);

    }

    @Override
    public String toString() {
        
        return "Movie: " + this.getName();
    }

}
