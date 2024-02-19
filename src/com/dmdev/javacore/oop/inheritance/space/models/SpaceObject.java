package com.dmdev.javacore.oop.inheritance.space.models;

import java.util.Objects;

public abstract class SpaceObject implements Comparable<SpaceObject> {

    private long mass;
    private double circle;

    public SpaceObject(long mass, double circle) {
        this.mass = mass;
        this.circle = circle;
    }

    public double getDiameter() {
        return circle / Math.PI;
    }

    public long getMass() {
        return mass;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public double getCircle() {
        return circle;
    }

    public void setCircle(double circle) {
        this.circle = circle;
    }

    public abstract void describeOrbit();

    @Override
    public int compareTo(SpaceObject spaceObject) {
        return Long.compare(this.getMass(), spaceObject.getMass());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceObject that = (SpaceObject) o;
        return mass == that.mass && Double.compare(circle, that.circle) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass, circle);
    }
}
