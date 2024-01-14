package com.example;

public enum Country {
    SAN_FRANCISCO,
    BARCELONA,
    PARIS,
    BERLIN,
    LONDON;

    @Override
    public String toString() {
        switch (this) {
            case SAN_FRANCISCO:
                return "San_Francisco";
            case BARCELONA:
                return "Barcelona";
            case PARIS:
                return "Paris";
            case BERLIN:
                return "Berlin";
            default:
                return null;
        }
    }


}
