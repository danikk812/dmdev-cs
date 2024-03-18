package com.dmdev.javacore.multithreading.crystals.competition;

import com.dmdev.javacore.multithreading.crystals.entity.Crystal;
import com.dmdev.javacore.multithreading.crystals.entity.Rocket;
import com.dmdev.javacore.multithreading.crystals.entity.enums.CrystalColor;
import com.dmdev.javacore.multithreading.crystals.entity.enums.MagicianType;
import com.dmdev.javacore.multithreading.crystals.exception.MagicianInterruptedException;
import com.dmdev.javacore.multithreading.crystals.storage.CrystalStorage;
import com.dmdev.javacore.multithreading.crystals.util.RandomGeneratorUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class Magician implements Runnable {

    private final MagicianType type;
    private final CrystalStorage crystalStorage;
    private final AtomicInteger redCrystalsCollected;
    private final AtomicInteger whiteCrystalsCollected;

    public Magician(MagicianType type, CrystalStorage crystalStorage, AtomicInteger redCrystalsCollected, AtomicInteger whiteCrystalsCollected) {
        this.type = type;
        this.crystalStorage = crystalStorage;
        this.redCrystalsCollected = redCrystalsCollected;
        this.whiteCrystalsCollected = whiteCrystalsCollected;
    }

    @Override
    public void run() {
        while (!crystalStorage.isCompetitionOver()) {
            Rocket rocket = fetchCrystals();
            unloadCrystals(rocket);
            logProgress();
            try {
                Thread.sleep(1000); // Travel time
            } catch (InterruptedException e) {
                throw new MagicianInterruptedException(this.type + " magician was interrupted while space rocket flight");
            }
        }
    }

    private Rocket fetchCrystals() {
        int cargoSize = RandomGeneratorUtil.generateInt(2, 5);
        Crystal[] cargo = new Crystal[cargoSize];
        for (int i = 0; i < cargoSize; i++) {
            cargo[i] = crystalStorage.takeCrystal();
        }
        return new Rocket(cargo);
    }

    private void unloadCrystals(Rocket rocket) {
        Crystal[] cargo = rocket.getCargo();
        for (Crystal crystal : cargo) {
            if (crystal != null) {
                if (crystal.getColor() == CrystalColor.RED) {
                    redCrystalsCollected.incrementAndGet();
                } else {
                    whiteCrystalsCollected.incrementAndGet();
                }
            }
        }
    }

    private void logProgress() {
        System.out.println("Magician " + type + " has collected:");
        System.out.println("Red crystals: " + redCrystalsCollected.get());
        System.out.println("White crystals: " + whiteCrystalsCollected.get());
        System.out.println();
    }

}