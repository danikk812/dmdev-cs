package com.dmdev.javacore.regexp.supportservice.service;

import com.dmdev.javacore.regexp.supportservice.entity.Complaint;
import com.dmdev.javacore.regexp.supportservice.util.PhoneFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DispatcherService {

    private final ExecutorService executorService;
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
    private static final String PROCESSED_COMPLAINTS_FILE = "src/com/dmdev/javacore/regexp/supportservice/resources/processed-complaints.log";

    public DispatcherService(int numberOfDispatchers) {
        this.executorService = Executors.newFixedThreadPool(numberOfDispatchers);
    }

    public void processComplaints(List<Complaint> complaints) {
        for (Complaint complaint : complaints) {
            executorService.submit(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 3000) + 2000); // random delay from 2 to 5 seconds
                    writeToProcessedComplaintsFile(complaint);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Call was interrupted", e);
                }
            });
        }
        executorService.shutdown();
    }

    private void writeToProcessedComplaintsFile(Complaint complaint) {
        String formattedPhoneNumber;
        try {
            formattedPhoneNumber = PhoneFormatter.formatPhoneNumber(complaint.getPhoneNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);

        String processedComplaint = complaint.getClientId() + ", " + formattedDateTime + ", " + formattedPhoneNumber + "\n";

        Path processedComplaintsFilePath = Paths.get(PROCESSED_COMPLAINTS_FILE);
        try {
            Files.write(processedComplaintsFilePath, processedComplaint.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Complaint with id " + complaint.getClientId() + " processed");
        } catch (IOException e) {
            throw new RuntimeException("Error writing to processed complaints file" + processedComplaintsFilePath, e);
        }
    }
}
