package net.creqavn.tasks;
import java.util.Random;

public class GenerateRandomValue {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";

    public static String generateEmail() {
        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
            sb.append("@yoopmail.com");
        }
        return sb.toString();
    }

    public static String generateUserName(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        String combinedChars = CHARACTERS + NUMBERS; // Kết hợp ký tự và số
        for (int i = 0; i < length; i++) {
            sb.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }
        return sb.toString();
    }

    public static String generatePhoneNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("09");
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        return sb.toString();
    }
}
