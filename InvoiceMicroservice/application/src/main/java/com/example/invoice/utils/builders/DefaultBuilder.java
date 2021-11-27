package com.example.invoice.utils.builders;

import com.example.invoice.enums.MovieGenres;
import com.example.invoice.enums.MpaaRatings;
import com.example.invoice.utils.builders.movies.DefaultMovieBuilder;

import java.util.Date;
import java.util.List;

public class DefaultBuilder {
    public static DefaultMovieBuilder createDefaultMovieBuilder(){
        return new DefaultMovieBuilder()
                .withId(10)
                .withTitle("Default Movie")
                .withDescription("Default Description")
                .withYear(1900)
                .withReleaseDate(new Date())
                .withRuntimeInMinutes(100)
                .withMpaaRating(MpaaRatings.G)
                .withGenres(List.of(MovieGenres.ADVENTURE, MovieGenres.COMEDY));
    }
}
