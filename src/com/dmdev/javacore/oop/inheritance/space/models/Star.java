package com.dmdev.javacore.oop.inheritance.space.models;

import java.util.Objects;

public abstract class Star extends SpaceObject implements HeatEmitting {

    private String color;
    private boolean isAlive;

    public Star(long mass, double circle, String color, boolean isAlive) {
        super(mass, circle);
        this.color = color;
        this.isAlive = isAlive;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void emitHeat() {
        System.out.println("Star can emit heat");
        if (isAlive) {
            System.out.println("The star is emitting heat");
        } else {
            System.out.println("The star is no longer emitting heat");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Star star = (Star) o;
        return isAlive == star.isAlive && Objects.equals(color, star.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, isAlive);
    }
}
