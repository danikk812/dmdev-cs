package com.dmdev.javacore.regexp.supportservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PhoneFormatter {

    private static final String BELARUS_PHONE_PREFIX = "+375";
    private static final String PHONE_REGEX = "(\\+?375)?[\\s\\-]?\\(?\\d{2}\\)?[\\s\\-]?\\d{2,3}[\\s\\-]?\\d{2,3}[\\s\\-]?\\d{2,3}";

    private PhoneFormatter() {
    }

    public static String formatPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.find()) {
            StringBuilder formattedPhoneNumber = new StringBuilder(BELARUS_PHONE_PREFIX);

            String allDigits = (phoneNumber.length() > 9)
                    ? phoneNumber.replaceAll("\\D", "")
                    : (BELARUS_PHONE_PREFIX + phoneNumber).replaceAll("\\D", "");

            formattedPhoneNumber
                    .append(" (")
                    .append(allDigits, 3, 5)
                    .append(") ")
                    .append(allDigits, 5, 8)
                    .append("-")
                    .append(allDigits, 8, 10)
                    .append("-")
                    .append(allDigits, 10, 12);
            return formattedPhoneNumber.toString();
        } else {
            throw new IllegalArgumentException("Invalid phone number format: " + phoneNumber);
        }
    }
}
