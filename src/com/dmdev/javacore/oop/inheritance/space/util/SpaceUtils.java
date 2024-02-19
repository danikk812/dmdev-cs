package com.dmdev.javacore.oop.inheritance.space.util;

import com.dmdev.javacore.oop.inheritance.space.models.SpaceObject;
import com.dmdev.javacore.oop.inheritance.space.models.Star;

public class SpaceUtils {

    private static final double G = 6.674 * Math.pow(10, -11);

    private SpaceUtils() {

    }

    public static double gravityBetween(SpaceObject fisrtSpaceObject, SpaceObject secondSpaceObject, double distance) {
        return G * fisrtSpaceObject.getMass() * secondSpaceObject.getMass();
    }

    public static boolean isStar(SpaceObject spaceObject) {
        return spaceObject instanceof Star;
    }
}
