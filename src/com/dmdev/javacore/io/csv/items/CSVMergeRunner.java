package com.dmdev.javacore.io.csv.items;

import com.dmdev.javacore.io.csv.items.util.ItemsCSVUtil;

import java.io.IOException;
import java.nio.file.Path;

public class CSVMergeRunner {

    private static final String ITEMS_BASE_PATH = "src/com/dmdev/javacore/io/csv/items/resources/";
    private static final String ITEMS_PRICE_FILE_NAME = "items-price.csv";
    private static final String ITEMS_FILE_NAME = "items-name.csv";
    private static final String RESULT_FILE_NAME = "result.csv";
    private static final String ERRORS_FILE_NAME = "errors.csv";

    public static final String ITEMS_PRICE_CONTENT = """
            ID,PRICE
            1,9.98
            2,25.05
            3,16.45
            4,2.28
            """;

    public static final String ITEMS_NAME_CONTENT = """
            ID,NAME,DESCRIPTION
            1,Шарф,Теплый зимний шарф красного цвета
            2,Шапка,Вязаная зеленая шапка
            3,Ботинки,Осенние ботинки на толстой подошве
            """;

    public static void main(String[] args) {

        Path itemsFilePath = Path.of(ITEMS_BASE_PATH, ITEMS_FILE_NAME);
        Path itemsPriceFilePath = Path.of(ITEMS_BASE_PATH, ITEMS_PRICE_FILE_NAME);
        Path resultFilePath = Path.of(ITEMS_BASE_PATH, RESULT_FILE_NAME);
        Path errorsFilePath = Path.of(ITEMS_BASE_PATH, ERRORS_FILE_NAME);

        try {
            ItemsCSVUtil.createCSV(itemsFilePath, ITEMS_NAME_CONTENT);
            ItemsCSVUtil.createCSV(itemsPriceFilePath, ITEMS_PRICE_CONTENT);

            var names = ItemsCSVUtil.readNames(itemsFilePath);
            var prices = ItemsCSVUtil.readPrices(itemsPriceFilePath);

            var mergedItemsData = ItemsCSVUtil.mergeItemsData(prices, names);
            var itemsErrorData = ItemsCSVUtil.getItemsErrorData(prices, names);

            ItemsCSVUtil.saveResultCSV(mergedItemsData, resultFilePath);
            ItemsCSVUtil.saveErrorsCSV(itemsErrorData, errorsFilePath);

            System.out.println("Items merge completed successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while files processing " + e.getMessage());
        }

    }
}
