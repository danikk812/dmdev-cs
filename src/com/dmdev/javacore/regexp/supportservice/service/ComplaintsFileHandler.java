package com.dmdev.javacore.regexp.supportservice.service;

import com.dmdev.javacore.regexp.supportservice.entity.Complaint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ComplaintsFileHandler {

    private final Path filePath;
    private final AtomicInteger complaintsOffset = new AtomicInteger(0);
    private static final int COMPLAINT_COLUMNS_SIZE = 5;
    private static final int COMPLAINT_CLIENT_ID_INDEX = 0;
    private static final int COMPLAINT_CALL_DATETIME_INDEX = 1;
    private static final int COMPLAINT_FULLNAME_INDEX = 2;
    private static final int COMPLAINT_PHONE_NUMBER_INDEX = 3;
    private static final int COMPLAINT_TEXT_INDEX = 4;

    public ComplaintsFileHandler(String fileName) {
        this.filePath = Paths.get(fileName);
    }

    public List<Complaint> readComplaints() {
        List<Complaint> complaints = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath)) {
            int skip = complaintsOffset.get();
            lines.skip(skip)
                    .forEachOrdered(line -> {
                        complaints.add((parseComplaint(line)));
                        complaintsOffset.incrementAndGet();
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error reading complaints file " + filePath, e);
        }

        return complaints;
    }

    private Complaint parseComplaint(String line) {
        String[] parts = line.split(", ");

        if (parts.length != COMPLAINT_COLUMNS_SIZE) {
            throw new IllegalArgumentException("Invalid complaint format: " + line);
        }

        return new Complaint(
                Integer.parseInt(parts[COMPLAINT_CLIENT_ID_INDEX]),
                LocalDateTime.parse(parts[COMPLAINT_CALL_DATETIME_INDEX]),
                parts[COMPLAINT_FULLNAME_INDEX],
                parts[COMPLAINT_PHONE_NUMBER_INDEX],
                parts[COMPLAINT_TEXT_INDEX]
        );
    }

    public void addComplaint(Complaint complaint) {
        try {
            Files.writeString(filePath, complaint.toString() + System.lineSeparator(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Error adding complaint to file " + filePath, e);
        }
    }


}
