package com.example.invoice.utils.builders.movies;

import com.example.invoice.models.SampleMovieModel;
import com.example.invoice.enums.MovieGenres;
import com.example.invoice.enums.MpaaRatings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DefaultMovieBuilder {
    private int id;
    private String title;
    private String description;
    private int year;
    private Date releaseDate;
    private int runtime;
    private MpaaRatings mpaaRating;
    private List<MovieGenres> genres;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm");

    public DefaultMovieBuilder withId(final int id){
        this.id = id;
        return this;
    }

    public DefaultMovieBuilder withTitle(final String title){
        this.title = title;
        return this;
    }

    public DefaultMovieBuilder withDescription(final String description){
        this.description = description;
        return this;
    }

    public DefaultMovieBuilder withYear(final int year){
        this.year = year;
        return this;
    }

    public DefaultMovieBuilder withReleaseDate(final Date releaseDate){
        this.releaseDate = releaseDate;
        return this;
    }

    public DefaultMovieBuilder withRuntimeInMinutes(final int runtime){
        this.runtime = runtime;
        return this;
    }

    public DefaultMovieBuilder withMpaaRating(final MpaaRatings rating){
        this.mpaaRating = rating;
        return this;
    }

    public DefaultMovieBuilder withGenres(final List<MovieGenres> genres){
        this.genres = genres;
        return this;
    }

    public SampleMovieModel build(){
        final SampleMovieModel movieModel = new SampleMovieModel();

        movieModel.setId(id);
        movieModel.setTitle(title);
        movieModel.setDescription(description);
        movieModel.setYear(year);
        movieModel.setReleaseDate(dateFormat.format(releaseDate));
        movieModel.setRuntime(runtime);
        movieModel.setMpaaRating(mpaaRating);
        movieModel.setGenres(genres);

        return movieModel;
    }
}
