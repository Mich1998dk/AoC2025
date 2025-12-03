package aoc.days;

import java.util.Arrays;
import java.util.List;

import aoc.util.AocUtil;

public class Day02 {
    private static final String DAY_INPUT_FILE = "./day02/input.txt";

    private static List<String> sonar;

    private static void init() throws Exception {
        sonar = AocUtil.readFileToStrings(DAY_INPUT_FILE);
    }

    public static String solvePart1() throws Exception {
        init();
        long sum = 0;
        List<String> ranges = Arrays.stream(sonar.get(0).split(",")).toList();
        for (String range : ranges) {
            long startNumber = Long.parseLong(range.split("-")[0]);
            long endNumber = Long.parseLong(range.split("-")[1]);
            for (long i = startNumber; i <= endNumber; i++) {
                String number = Long.toString(i);
                String firstHalf = number.substring(0, number.length() / 2);
                String secondHalf = number.substring(number.length() / 2);
                if (firstHalf.equals(secondHalf)) {
                    sum += i;
                }
            }
        }
        return Long.toString(sum);
    }

    public static String solvePart2() throws Exception {
        init();
        long sum = 0;
        List<String> ranges = Arrays.stream(sonar.get(0).split(",")).toList();
        for (String range : ranges) {
            long startNumber = Long.parseLong(range.split("-")[0]);
            long endNumber = Long.parseLong(range.split("-")[1]);
            for (long i = startNumber; i <= endNumber; i++) {
                String number = Long.toString(i);
                for (int patternLength = 1; patternLength <= number.length()/2; patternLength++) {
                    if (number.length() % patternLength == 0) {
                        String pattern = number.substring(0, patternLength);
                        int numberOfRepeats =  number.length() / patternLength;

                        if (pattern.repeat(numberOfRepeats).equals(number)) {
                            sum += i;
                            break;
                        }
                    }
                }
            }
        }
        return Long.toString(sum);
    }
}
