package aoc.days;

import java.util.List;

import aoc.util.AocUtil;

public class Day01 {

    private static final String DAY_INPUT_FILE = "./day01/input.txt";

    private static List<String> sonar;

    private static void init() throws Exception {
        sonar = AocUtil.readFileToStrings(DAY_INPUT_FILE);
    }

    public static String solvePart1() throws Exception {
        init();
        int position = 50;
        int counter = 0;

        for (String rotation : sonar) {
            String direction = rotation.substring(0, 1);
            int clicks = Integer.parseInt(rotation.substring(1));
            if (direction.equals("R")) {
                position = (position + clicks) % 100;
            } else {
                position = (position - clicks) % 100;
            }
            if (position == 0) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }

    public static String solvePart2() throws Exception {
        init();
        int position = 50;
        long counter = 0;

        for (String rotation : sonar) {
            String direction = rotation.substring(0, 1);
            int clicks = Integer.parseInt(rotation.substring(1));

            int remainingClicks = clicks % 100;
            int startPosition = position;
            counter += clicks / 100;

            if (direction.equals("R")) {
                if (startPosition + remainingClicks >= 100) {
                    counter++;
                }
                position = (startPosition + clicks) % 100;
            } else {

                if (startPosition != 0 && startPosition - remainingClicks <= 0) {
                    counter++;
                }
                position = (startPosition - remainingClicks % 100 + 100) % 100;
            }
        }
        return Long.toString(counter);
    }
}