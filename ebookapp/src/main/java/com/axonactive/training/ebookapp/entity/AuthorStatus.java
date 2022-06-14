package com.axonactive.training.ebookapp.entity;

public enum AuthorStatus {
    DECEASED (-1),
    NONACTIVE (0),
    ACTIVE (1);


    private int value;

    AuthorStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
