package net.creqavn.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {

    public static String username() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public static String phoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String password() {
        return RandomStringUtils.randomAlphabetic(6);
    }
}
