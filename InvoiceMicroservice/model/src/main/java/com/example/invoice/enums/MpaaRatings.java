package com.example.invoice.enums;

public enum MpaaRatings {

    UNKNOWN(0, "No Description"),
    G(1, "General Audiences"),
    PG_13(2, "Parents Strongly Cautioned"),
    R(3, "Restricted "),
    NC_17(4, "No One 17 and Under Admitted");

    private int index;
    private String description;

    MpaaRatings(int index, String description){
        this.index = index;
        this.description = description;
    }
}
