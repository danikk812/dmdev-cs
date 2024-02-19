package com.dmdev.javacore.oop.inheritance.space;

import com.dmdev.javacore.oop.inheritance.space.models.Planet;
import com.dmdev.javacore.oop.inheritance.space.models.YellowDwarf;
import com.dmdev.javacore.oop.inheritance.space.util.SpaceUtils;

public class SpaceApplication {

    public static void main(String[] args) {

        Planet earth = new Planet(50, 67, "Earth", true);
        earth.checkInhabited();
        earth.describeOrbit();
        System.out.println();

        YellowDwarf sun = new YellowDwarf(100, 100, "yellow", true);
        sun.emitHeat();
        sun.explode();
        sun.describeOrbit();
        System.out.println();

        System.out.println("Is a star - " + SpaceUtils.isStar(sun));
        System.out.println("Is a star - " + SpaceUtils.isStar(earth));
        System.out.println();
        System.out.println("Gravitation: " + SpaceUtils.gravityBetween(earth, sun, 10000));
    }
}
