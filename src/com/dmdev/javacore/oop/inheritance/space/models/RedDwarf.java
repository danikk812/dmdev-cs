package com.dmdev.javacore.oop.inheritance.space.models;

public class RedDwarf extends Star implements Explosive {

    public RedDwarf(long mass, double circle, String color, boolean isAlive) {
        super(mass, circle, color, isAlive);
    }

    @Override
    public void describeOrbit() {
        System.out.println("Orbiting the red dwarf");
    }

    @Override
    public void explode() {
        System.out.println("Red dwarf has small chance of explosion");
    }


    @Override
    public String toString() {
        return "RedDwarf{" +
                "color='" + getColor() + '\'' +
                ", isAlive='" + isAlive() + '\'' +
                ", mass=" + getMass() +
                ", circle=" + getCircle() +
                '}';
    }


}
