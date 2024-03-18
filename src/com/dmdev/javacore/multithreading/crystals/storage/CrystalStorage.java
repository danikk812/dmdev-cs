package com.dmdev.javacore.multithreading.crystals.storage;

import com.dmdev.javacore.multithreading.crystals.entity.Crystal;
import com.dmdev.javacore.multithreading.crystals.entity.enums.CrystalColor;
import com.dmdev.javacore.multithreading.crystals.util.RandomGeneratorUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class CrystalStorage {

    public static final int REQUIRED_RED_CRYSTALS = 20;
    public static final int REQUIRED_WHITE_CRYSTALS = 20;
    private static final int MAX_CRYSTALS_PER_DAY = 5;
    private final AtomicInteger redCrystals;
    private final AtomicInteger whiteCrystals;
    private volatile boolean competitionOver = false;

    public CrystalStorage() {
        redCrystals = new AtomicInteger(0);
        whiteCrystals = new AtomicInteger(0);
    }

    public synchronized Crystal takeCrystal() {
        if (redCrystals.get() >= REQUIRED_RED_CRYSTALS && whiteCrystals.get() >= REQUIRED_WHITE_CRYSTALS) {
            competitionOver = true;
            return null;
        }
        if (RandomGeneratorUtil.generateBoolean()) {
            if (redCrystals.getAndIncrement() < REQUIRED_RED_CRYSTALS) {
                return new Crystal(CrystalColor.RED);
            }
        } else {
            if (whiteCrystals.getAndIncrement() < REQUIRED_WHITE_CRYSTALS) {
                return new Crystal(CrystalColor.WHITE);
            }
        }
        return null;
    }

    public boolean isCompetitionOver() {
        return competitionOver;
    }
}
