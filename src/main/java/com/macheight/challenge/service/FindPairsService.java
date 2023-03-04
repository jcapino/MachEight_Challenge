package com.macheight.challenge.service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPairsService {
    private static final String REGEX_VALIDATION = "^(?!\\s)([-]?\\d+(,[-]?\\d+)*)?\\s([-]?\\d+)$";
    private static final String REGEX_BLANK_SPACE_SEPARATOR = "\\s";
    private static final String REGEX_COMMA_SEPARATOR = ",";

    public void run(String inputString) {
        if (isInputDataValid(inputString)) {
            findPairs(inputString).forEach(System.out::println);
        } else {
            throw new RuntimeException("Invalid input data... Finished program :)");
        }
    }

    private Boolean isInputDataValid(String inputString) {
        Pattern pattern = Pattern.compile(REGEX_VALIDATION);
        Matcher matcher = pattern.matcher(inputString);
        return matcher.matches();
    }

    private List<String> findPairs(String inputString) {
        String[] data = inputString.split(REGEX_BLANK_SPACE_SEPARATOR);
        int[] numbers = getInputNumbers(data[0]);
        int givenValue = Integer.parseInt(data[1]);

        Map<Integer, Integer> map = new HashMap<>();
        List<String> pairNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            // if the difference has been calculated before, it means that matches with the givenValue
            int difference = givenValue - numbers[i];
            if (map.containsKey(difference)) {
                int firstValue = numbers[map.get(difference)];
                pairNumbers.add("+ " + firstValue + "," + numbers[i]);
            }
            map.put(numbers[i], i);
        }
        return pairNumbers;
    }

    private int[] getInputNumbers(String inputData) {
        return Arrays.stream(inputData.split(REGEX_COMMA_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
    }
}

