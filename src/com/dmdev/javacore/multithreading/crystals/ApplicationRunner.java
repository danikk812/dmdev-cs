package com.dmdev.javacore.multithreading.crystals;

import com.dmdev.javacore.multithreading.crystals.competition.Magician;
import com.dmdev.javacore.multithreading.crystals.entity.enums.MagicianType;
import com.dmdev.javacore.multithreading.crystals.storage.CrystalStorage;
import com.dmdev.javacore.multithreading.crystals.util.CompetitionUtil;
import com.dmdev.javacore.multithreading.crystals.util.ThreadsUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class ApplicationRunner {

    public static void main(String[] args) {
        CrystalStorage crystalWarehouse = new CrystalStorage();
        AtomicInteger redCrystalsCollected = new AtomicInteger(0);
        AtomicInteger whiteCrystalsCollected = new AtomicInteger(0);

        Magician fireMagician = new Magician(MagicianType.FIRE, crystalWarehouse, redCrystalsCollected, whiteCrystalsCollected);
        Magician airMagician = new Magician(MagicianType.AIR, crystalWarehouse, redCrystalsCollected, whiteCrystalsCollected);

        ThreadsUtil.startThreads(fireMagician, airMagician);
        ThreadsUtil.joinThreads();

        CompetitionUtil.printCompetitionEnd();
    }
}
