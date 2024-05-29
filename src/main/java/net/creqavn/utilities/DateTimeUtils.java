package net.creqavn.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DateTimeUtils {
    public static String formatHH_MM_SS() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH_mm_ss");
        return now.format(formatter);
    }

    public static String formatHH_MM() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH_mm");
        return now.format(formatter);
    }

    public static String formatYYYY_MM_DD_HH_MM_SS() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        return now.format(formatter);
    }

    public static String formatYYYY_MM_DD_HH() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH");
        return now.format(formatter);
    }

    public static String formatYYYY_MM_DD() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        return now.format(formatter);
    }

    public static String setFolderName() {
        List<String> words = Arrays.asList(
                formatYYYY_MM_DD());
        return String.join("_", words);
    }
}
