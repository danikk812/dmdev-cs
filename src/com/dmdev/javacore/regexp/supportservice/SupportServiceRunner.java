package com.dmdev.javacore.regexp.supportservice;

import com.dmdev.javacore.regexp.supportservice.service.ComplaintsFileHandler;
import com.dmdev.javacore.regexp.supportservice.service.DispatcherService;
import com.dmdev.javacore.regexp.supportservice.service.ScheduledComplaintProcessor;

public class SupportServiceRunner {

    private static final String COMPLAINTS_FILE = "src/com/dmdev/javacore/regexp/supportservice/resources/complaints.log";

    public static void main(String[] args) {

        ComplaintsFileHandler complaintsFileHandler = new ComplaintsFileHandler(COMPLAINTS_FILE);
        DispatcherService dispatcherService = new DispatcherService(3);
        ScheduledComplaintProcessor complaintProcessor = new ScheduledComplaintProcessor(complaintsFileHandler, dispatcherService);

        complaintProcessor.startProcessing();

        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After 10 minutes stop the app execution
        complaintProcessor.stopProcessing();
    }
}
