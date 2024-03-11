package com.dmdev.javacore.io.csv.items.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ItemsCSVUtil {

    private ItemsCSVUtil() {
    }

    public static void createCSV(Path path, String content) throws IOException {
        Files.write(path, Collections.singleton(content.trim()));
    }

    public static Map<String, String[]> readNames(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toMap(
                            arr -> arr[0],
                            arr -> new String[]{arr[1], arr[2]}
                    ));
        }
    }

    public static Map<String, String> readPrices(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toMap(
                            arr -> arr[0],
                            arr -> arr[1],
                            ((exist, replace) -> exist)
                    ));
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

    public static void saveResultCSV(Map<String, String> mergedItemsData, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("ID,NAME,PRICE");
        lines.addAll(mergedItemsData.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList()));
        Files.write(path, lines);
    }

    public static void saveErrorsCSV(List<String> itemsErrorData, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("ID");
        lines.addAll(itemsErrorData);
        Files.write(path, lines);
    }
}
