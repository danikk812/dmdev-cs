package com.dmdev.javacore.oop.intro;

import com.dmdev.javacore.oop.intro.entity.Building;
import com.dmdev.javacore.oop.intro.entity.Flat;
import com.dmdev.javacore.oop.intro.entity.Floor;
import com.dmdev.javacore.oop.intro.entity.Room;
import com.dmdev.javacore.oop.intro.util.ConsolePrinter;

public class BuildingApplication {

    public static void main(String[] args) {

        Room room = new Room(true);
        Room room2 = new Room(false);

        Flat flat = new Flat(1, new Room[]{room, room2});
        Flat flat2 = new Flat(2, new Room[]{room, room});
        Flat flat3 = new Flat(3, new Room[]{room2, room2});
        Flat flat4 = new Flat(4, new Room[]{room2, room});
        Flat flat5 = new Flat(5, new Room[]{room, room2});
        Flat flat6 = new Flat(6, new Room[]{room2, room});
        Flat flat7 = new Flat(7, new Room[]{room2, room});
        Flat flat8 = new Flat(8, new Room[]{room, room2});
        Flat flat9 = new Flat(9, new Room[]{room2, room2});

        Floor floor = new Floor(1, new Flat[]{flat, flat2, flat3});
        Floor floor2 = new Floor(2, new Flat[]{flat4, flat5, flat6});
        Floor floor3 = new Floor(3, new Flat[]{flat7, flat8, flat9});

        Building building = new Building(1, new Floor[]{floor, floor2, floor3});

        ConsolePrinter.printAllInformation(building);
    }
}
