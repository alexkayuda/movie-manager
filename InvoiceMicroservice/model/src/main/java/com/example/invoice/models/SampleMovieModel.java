package com.example.invoice.models;

import com.example.invoice.enums.MovieGenres;
import com.example.invoice.enums.MpaaRatings;

import java.util.List;

public class SampleMovieModel {
    private int id;
    private String title;
    private String description;
    private String releaseDate;
    private int runtime;
    private MpaaRatings mpaaRating;
    private List<MovieGenres> genres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public MpaaRatings getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MpaaRatings mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public List<MovieGenres> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieGenres> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "SampleMovieModel {" +
                "id=" + id +
                ", title=" + title +
                ", description=" + description +
                ", releaseDate=" + releaseDate +
                ", runtime=" + runtime +
                ", mpaaRating=" + mpaaRating.toString() +
                ", genres=" + genres.toString() +
                '}';
    }
}
