package com.dmdev.javacore.oop.inheritance.space.models;

public class YellowDwarf extends Star implements Explosive {

    public YellowDwarf(long mass, double circle, String color, boolean isAlive) {
        super(mass, circle, color, isAlive);
    }

    @Override
    public void describeOrbit() {
        System.out.println("Orbiting the yellow dwarf");
    }

    @Override
    public void explode() {
        System.out.println("Yellow dwarf has medium chance of explosion");
    }


    @Override
    public String toString() {
        return "YellowDwarf{" +
                "color='" + getColor() + '\'' +
                ", isAlive='" + isAlive() + '\'' +
                ", mass=" + getMass() +
                ", circle=" + getCircle() +
                '}';
    }
}
