package com.dmdev.javacore.oop.intro.entity;

import java.util.Arrays;

public class Floor {

    private int number;
    private Flat[] flats;

    public Floor(int number, Flat[] flats) {
        this.number = number;
        this.flats = flats;
    }

    public int getNumber() {
        return number;
    }

    public Flat[] getFlats() {
        return flats;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", flatsNumber=" + flats.length +
                ",\n\tflats=" + Arrays.toString(flats) +
                "}\n";
    }
}
