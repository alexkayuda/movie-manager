package com.example.invoice.utils.builders;

import com.example.invoice.enums.MovieGenres;
import com.example.invoice.enums.MpaaRatings;
import com.example.invoice.utils.builders.movies.DefaultMovieBuilder;

import java.util.Date;
import java.util.List;

public class DefaultBuilder {
    public static DefaultMovieBuilder createDefaultMovieBuilder(){
        return new DefaultMovieBuilder()
                .withId(13)
                .withTitle("In Time")
                .withDescription("Instead of using fiat money as currency,\" +\n" +
                        "                        \" a new economic system uses time as currency,\" +\n" +
                        "                        \" and each person has a clock on their arm that counts down how long they have to live.")
                .withReleaseDate(new Date())
                .withRuntimeInMinutes(109)
                .withMpaaRating(MpaaRatings.PG_13)
                .withGenres(List.of(MovieGenres.ACTION, MovieGenres.SCIFI));
    }
}
