package ru.kata.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.MethodOrderer;

import java.awt.*;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class TestDataGenerator {


    public static String generateData(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }

    public static String generateEmail() {
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString+"@gmail.com";
    }

    public static String generateDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return simpleDateFormat.format(date);

    }

}
