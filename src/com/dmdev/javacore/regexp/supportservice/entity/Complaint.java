package com.dmdev.javacore.regexp.supportservice.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Complaint {

    private int clientId;
    private LocalDateTime callDateTime;
    private String fullName;
    private String phoneNumber;
    private String complaintText;

    public Complaint(int clientId, LocalDateTime callDateTime, String fullName, String phoneNumber, String complaintText) {
        this.clientId = clientId;
        this.callDateTime = callDateTime;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.complaintText = complaintText;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getCallDateTime() {
        return callDateTime;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getComplaintText() {
        return complaintText;
    }

    @Override
    public String toString() {
        return clientId + ", " + callDateTime + ", " + fullName + ", " + phoneNumber + ", " + complaintText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return clientId == complaint.clientId && Objects.equals(callDateTime, complaint.callDateTime) && Objects.equals(fullName, complaint.fullName) && Objects.equals(phoneNumber, complaint.phoneNumber) && Objects.equals(complaintText, complaint.complaintText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, callDateTime, fullName, phoneNumber, complaintText);
    }
}
