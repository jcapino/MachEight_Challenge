package com.macheight.challenge;

import com.macheight.challenge.service.FindPairsService;

import java.util.*;

public class FindPairsApplication {
    private static final String APP_INSTRUCTIONS = "Sample input is shown below.\n" +
            "> app 1,9,5,0,20,-4,12,16,7 12\n \n" +
            "+ 12,0\n" +
            "+ 5,7\n" +
            "+ 16,-4\n";
    private static final String ASSUMPTIONS = "[Assumptions] => " +
            "I can assume that all input values are integers.\n" +
            "I can assume that there aren't any repeat values in the list\n";

    public static void main(String[] args) {
        System.out.println(APP_INSTRUCTIONS);
        System.out.println(ASSUMPTIONS);
        System.out.print("> app ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        FindPairsService fpService = new FindPairsService();
        fpService.run(inputString);
    }
}
