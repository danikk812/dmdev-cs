package com.dmdev.javacore.oop.inheritance.space.models;

import java.util.Objects;

public class Planet extends SpaceObject implements Inhabited {

    private String name;
    private boolean isPopulated;

    public Planet(long mass, double circle, String name, boolean isPopulated) {
        super(mass, circle);
        this.name = name;
        this.isPopulated = isPopulated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPopulated() {
        return isPopulated;
    }

    public void setPopulated(boolean populated) {
        isPopulated = populated;
    }

    @Override
    public void checkInhabited() {
        if(isPopulated) {
            System.out.println("Planet is inhabited");
        } else {
            System.out.println("Planet is not inhabited");
        }
    }

    @Override
    public void describeOrbit() {
        System.out.println("Orbiting the " + getName() +  " around the star");
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + getName() + '\'' +
                ", isPopulated='" + isPopulated() + '\'' +
                ", mass=" + getMass() +
                ", circle=" + getCircle() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Planet planet = (Planet) o;
        return isPopulated == planet.isPopulated && Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, isPopulated);
    }


}
