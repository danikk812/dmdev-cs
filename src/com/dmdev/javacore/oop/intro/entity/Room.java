package com.dmdev.javacore.oop.intro.entity;

import java.util.Objects;

public class Room {

    private boolean isWalkThrough;

    public Room(boolean isWalkThrough) {
        this.isWalkThrough = isWalkThrough;
    }

    public boolean isWalkThrough() {
        return isWalkThrough;
    }

    public void setWalkThrough(boolean walkThrough) {
        isWalkThrough = walkThrough;
    }

    @Override
    public String toString() {
        String roomDescription = (isWalkThrough) ? "walk-through" : "not walk-through";
        return "Room{" +
                roomDescription +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return isWalkThrough == room.isWalkThrough;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWalkThrough);
    }
}
