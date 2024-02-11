package com.dmdev.javacore.oop.intro.entity;

import java.util.Arrays;
import java.util.Objects;

public class Flat {

    private int number;
    private Room[] rooms;

    public Flat(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public int getNumber() {
        return number;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", roomsNumber=" + rooms.length +
                ", rooms=" + Arrays.toString(rooms) +
                "}\n\t ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && Arrays.equals(rooms, flat.rooms);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }
}
