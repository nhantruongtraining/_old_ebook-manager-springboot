package com.axonactive.training.ebookapp.entity;

public enum AuthorStatus {
    DECEASED (-1),
    INACTIVE (0),
    ACTIVE (1),
    UNKNOWN (2);


    private int value;

    AuthorStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
