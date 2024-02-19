package com.dmdev.javacore.oop.inheritance.space.models;

import java.util.Objects;

public class Satellite extends SpaceObject {
    private final Planet orbitingPlanet;

    public Satellite(long mass, double circle, Planet orbitingPlanet) {
        super(mass, circle);
        this.orbitingPlanet = orbitingPlanet;
    }

    public SpaceObject getOrbitingPlanet() {
        return orbitingPlanet;
    }

    public String getOrbitingPlanetName() {
        return orbitingPlanet.getName();
    }

    public void describeOrbit() {
        System.out.println("Orbiting around " + getOrbitingPlanetName());
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "orbitingPlanet='" + getOrbitingPlanetName() + '\'' +
                ", mass=" + getMass() +
                ", circle=" + getCircle() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Satellite satellite = (Satellite) o;
        return Objects.equals(orbitingPlanet, satellite.orbitingPlanet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orbitingPlanet);
    }
}
