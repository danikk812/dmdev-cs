package com.dmdev.javacore.regexp.supportservice.service;

import com.dmdev.javacore.regexp.supportservice.entity.Complaint;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledComplaintProcessor {

    private ComplaintsFileHandler complaintsFileHandler;
    private DispatcherService dispatcherService;
    private ScheduledExecutorService scheduledExecutorService;

    public ScheduledComplaintProcessor(ComplaintsFileHandler complaintsFileHandler, DispatcherService dispatcherService) {
        this.complaintsFileHandler = complaintsFileHandler;
        this.dispatcherService = dispatcherService;
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }

    public void startProcessing() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Start reading new complaints...");
            List<Complaint> complaints = complaintsFileHandler.readComplaints();
            System.out.println("Read " + complaints.size() + " new complaints.");
            System.out.println("Dispatching complaints...");
            dispatcherService.processComplaints(complaints);
        }, 0, 2, java.util.concurrent.TimeUnit.MINUTES);
    }

    public void stopProcessing() {
        scheduledExecutorService.shutdown();
        try {
            if (!scheduledExecutorService.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduledExecutorService.shutdownNow();
                if (!scheduledExecutorService.awaitTermination(1, TimeUnit.MINUTES)) {
                    System.err.println("ScheduledComplaintProcessor did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            scheduledExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


}
