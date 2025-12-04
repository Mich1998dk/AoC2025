package aoc.days;

import java.util.List;

import aoc.util.AocUtil;

public class Day04 {
    private static final String DAY_INPUT_FILE = "./day04/input.txt";

    private static List<String> sonar;

    private static void init() throws Exception {
        sonar = AocUtil.readFileToStrings(DAY_INPUT_FILE);
    }

    public static String solvePart1() throws Exception {
        init();
        int sum = 0;
        for (int i = 0; i < sonar.size(); i++) {
            String line = sonar.get(i);
            for (int j = 0; j < line.length(); j++) {
                char slot = line.charAt(j);
                int counter = 0;
                if (slot == '@') {
                    if (i > 0) {
                        counter += checkAbove(j, i, line);
                    }
                    counter += checkSameLine(j, line);
                    if (i < sonar.size() -1) {
                        counter += checkBelow(j, i, line);
                    }
                    if (counter < 4) {
                        sum++;
                        //System.out.print(counter);
                    } else {
                        //System.out.print("@");
                    }
                } else {
                    //System.out.print(".");
                }
            }
            //System.out.println("");
        }
        return ""+sum;
    }

    private static int checkSameLine(int j, String line) {
        int counter = 0;
        if (j != 0) {
            if (line.charAt(j - 1) == '@') {
                counter++;
            }
        }
        if (j != line.length() - 1) {
            if (line.charAt(j + 1) == '@') {
                counter++;
            }
        }
        return counter;
    }

    private static int checkAbove(int j, int i, String line) {
        int counter = 0;
        if (j > 0) {
            if (sonar.get(i-1).charAt(j-1) == '@') {
                counter++;
            }
        }
        if (sonar.get(i-1).charAt(j) == '@') {
            counter++;
        }
        if (j < line.length()-1) {
            if (sonar.get(i-1).charAt(j+1) == '@') {
                counter++;
            }
        }
        return counter;
    }

    private static int checkBelow(int j, int i, String line) {
        int counter = 0;
        if (j > 0) {
            if (sonar.get(i+1).charAt(j -1) == '@') {
                counter++;
            }
        }
        if (sonar.get(i+1).charAt(j) == '@') {
            counter++;
        }
        if (j < line.length() - 1) {
            if (sonar.get(i+1).charAt(j +1) == '@') {
                counter++;
            }
        }
        return counter;
    }

    public static String solvePart2() throws Exception {
        init();
        return null;
    }
}
