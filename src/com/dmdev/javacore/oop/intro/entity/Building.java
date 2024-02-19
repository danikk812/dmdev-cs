package com.dmdev.javacore.oop.intro.entity;

import java.util.Arrays;
import java.util.Objects;

public class Building {

    private int number;
    private Floor[] floors;

    public Building(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
    }

    public int getNumber() {
        return number;
    }

    public Floor[] getFloors() {
        return floors;
    }

    @Override
    public String toString() {
        return "Building{" +
                "number=" + number +
                ", floorsNumber=" + floors.length +
                ", floors=" + Arrays.toString(floors) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return number == building.number && Arrays.equals(floors, building.floors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(floors);
        return result;
    }
}
