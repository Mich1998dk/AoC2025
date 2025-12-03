package aoc.days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc.util.AocUtil;

public class Day03 {
    private static final String DAY_INPUT_FILE = "./day03/input.txt";

    private static List<String> sonar;

    private static void init() throws Exception {
        sonar = AocUtil.readFileToStrings(DAY_INPUT_FILE);
    }

    public static String solvePart1() throws Exception {
        init();
        long sum = 0;
        for (String line : sonar) {
            List<Integer> batteries = Arrays.stream(line.split("")).map(Integer::parseInt).toList();
            long firstBattery = 0;
            long secondBattery = 0;
            int allBatteriesInLine = batteries.size();
            for (int i = 0; i < allBatteriesInLine; i++) {
                Integer currentBattery = batteries.get(i);
                int remainingBatteries = allBatteriesInLine - (i + 1);
                if (currentBattery > firstBattery && remainingBatteries > 0) {
                    firstBattery = currentBattery;
                    secondBattery = 0;
                } else if (currentBattery > secondBattery) {
                    secondBattery = currentBattery;
                }
            }
            sum += Long.parseLong("" + firstBattery + secondBattery);
        }
        return Long.toString(sum);
    }

    public static String solvePart2() throws Exception {
        init();
        long sum = 0;
        for (String line : sonar) {
            List<Integer> batteries = Arrays.stream(line.split("")).map(Integer::parseInt).toList();
            long firstBattery = 0;
            long secondBattery = 0;
            long thirdBattery = 0;
            long fourthBattery = 0;
            long fifthBattery = 0;
            long sixthBattery = 0;
            long seventhBattery = 0;
            long eigthBattery = 0;
            long ninthBattery = 0;
            long tenthBattery = 0;
            long eleventhBattery = 0;
            long twelthBattery = 0;
            int allBatteriesInLine = batteries.size();
            for (int i = 0; i < allBatteriesInLine; i++) {
                Integer currentBattery = batteries.get(i);
                int remainingBatteries = allBatteriesInLine - (i + 1);
                if (currentBattery > firstBattery && remainingBatteries > 10) {
                    firstBattery = currentBattery;
                    secondBattery = 0;
                    thirdBattery = 0;
                    fourthBattery = 0;
                    fifthBattery = 0;
                    sixthBattery = 0;
                    seventhBattery = 0;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > secondBattery && remainingBatteries > 9) {
                    secondBattery = currentBattery;
                    thirdBattery = 0;
                    fourthBattery = 0;
                    fifthBattery = 0;
                    sixthBattery = 0;
                    seventhBattery = 0;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > thirdBattery && remainingBatteries > 8) {
                    thirdBattery = currentBattery;
                    fourthBattery = 0;
                    fifthBattery = 0;
                    sixthBattery = 0;
                    seventhBattery = 0;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > fourthBattery && remainingBatteries > 7) {
                    fourthBattery = currentBattery;
                    fifthBattery = 0;
                    sixthBattery = 0;
                    seventhBattery = 0;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > fifthBattery && remainingBatteries > 6) {
                    fifthBattery = currentBattery;
                    sixthBattery = 0;
                    seventhBattery = 0;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > sixthBattery && remainingBatteries > 5) {
                    sixthBattery = currentBattery;
                    seventhBattery = 0;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > seventhBattery && remainingBatteries > 4) {
                    seventhBattery = currentBattery;
                    eigthBattery = 0;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > eigthBattery && remainingBatteries > 3) {
                    eigthBattery = currentBattery;
                    ninthBattery = 0;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > ninthBattery && remainingBatteries > 2) {
                    ninthBattery = currentBattery;
                    tenthBattery = 0;
                    eleventhBattery = 0;
                    twelthBattery = 0;
                } else if (currentBattery > tenthBattery && remainingBatteries > 1) {
                    tenthBattery = currentBattery;
                    eleventhBattery = 0;
                } else if (currentBattery > eleventhBattery && remainingBatteries > 0) {
                    eleventhBattery = currentBattery;
                    twelthBattery = 0;
                } else if (currentBattery > twelthBattery) {
                    twelthBattery = currentBattery;
                }
            }
            sum += Long.parseLong("" + firstBattery + secondBattery + thirdBattery + fourthBattery + fifthBattery + sixthBattery + seventhBattery + eigthBattery + ninthBattery + tenthBattery + eleventhBattery + twelthBattery);
        }
        return Long.toString(sum);
    }
}
