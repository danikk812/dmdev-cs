package com.dmdev.javacore.oop.inheritance.space.models;

public class BlueDwarf extends Star implements Explosive {

    public BlueDwarf(long mass, double circle, String color, boolean isAlive) {
        super(mass, circle, color, isAlive);
    }

    @Override
    public void describeOrbit() {
        System.out.println("Orbiting the blue dwarf");
    }

    @Override
    public void explode() {
        System.out.println("Blue dwarf has high chance of explosion");
    }


    @Override
    public String toString() {
        return "BlueDwarf{" +
                "color='" + getColor() + '\'' +
                ", isAlive='" + isAlive() + '\'' +
                ", mass=" + getMass() +
                ", circle=" + getCircle() +
                '}';
    }
}
