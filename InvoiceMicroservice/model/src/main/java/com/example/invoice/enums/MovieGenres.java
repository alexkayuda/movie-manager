package com.example.invoice.enums;

public enum MovieGenres {

    ACTION,
    ADVENTURE,
    ANIMATION,
    COMEDY,
    DRAMA,
    HORROR,
    SCIFI,
    THRILLER,
    ROMANCE;

    private int value;

    MovieGenres() {
        value = 1 + ordinal();
    }

    /**
     * Returns the value of a particular genre
     * @return Genre's value
     */
    public int getValue() {
        return value;
    }
}
