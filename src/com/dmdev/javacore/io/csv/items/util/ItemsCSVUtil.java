package com.dmdev.javacore.io.csv.items.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ItemsCSVUtil {

    private static final int ITEMS_CSV_ID_INDEX = 0;
    private static final int ITEMS_CSV_NAME_INDEX = 1;
    private static final int ITEMS_CSV_DESCRIPTION_INDEX = 2;
    private static final int ITEMS_CSV_PRICE_INDEX = 1;

    private static final String ITEMS_RESULT_CSV_HEADER = "ID,NAME,PRICE";
    private static final  String ITEMS_ERRORS_CSV_HEADER = "ID";



    private ItemsCSVUtil() {
    }

    public static void createCSV(Path path, String content) {
        try {
            Files.write(path, Collections.singleton(content.trim()));
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while creating CSV file with createCSV() " + e, e);
        }
    }

    public static Map<String, String[]> readNames(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toMap(
                            arr -> arr[ITEMS_CSV_ID_INDEX],
                            arr -> new String[]{arr[ITEMS_CSV_NAME_INDEX], arr[ITEMS_CSV_DESCRIPTION_INDEX]}
                    ));
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading CSV file with readNames() " + e, e);
        }
    }

    public static Map<String, String> readPrices(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toMap(
                            arr -> arr[ITEMS_CSV_ID_INDEX],
                            arr -> arr[ITEMS_CSV_PRICE_INDEX],
                            ((exist, replace) -> exist)
                    ));
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading CSV file with readPrices() " + e, e);
        }
    }

    public static Map<String, String> mergeItemsData(Map<String, String> prices, Map<String, String[]> names) {
        return names.entrySet().stream()
                .filter(entry -> prices.containsKey(entry.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue()[0] + "," + prices.get(entry.getKey())
                ));
    }

    public static List<String> getItemsErrorData(Map<String, String> prices, Map<String, String[]> names) {
        Set<String> allIds = new HashSet<>(prices.keySet());
        allIds.addAll(names.keySet());

        return allIds.stream()
                .filter(id -> !prices.containsKey(id) || !names.containsKey(id))
                .collect(Collectors.toList());
    }

    public static void saveResultCSV(Map<String, String> mergedItemsData, Path path) {
        List<String> lines = new ArrayList<>();
        lines.add(ITEMS_RESULT_CSV_HEADER);
        lines.addAll(mergedItemsData.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList()));
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving CSV file with saveResultCSV() " + e, e);
        }
    }

    public static void saveErrorsCSV(List<String> itemsErrorData, Path path) {
        List<String> lines = new ArrayList<>();
        lines.add(ITEMS_ERRORS_CSV_HEADER);
        lines.addAll(itemsErrorData);
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading CSV file with saveErrorsCSV() " + e, e);
        }
    }
}
