package aoc.days;

import java.util.Arrays;
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
                    if (i < sonar.size() - 1) {
                        counter += checkBelow(j, i, line);
                    }
                    if (counter < 4) {
                        sum++;
                    }
                }
            }
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
        char[][] grid = sonar.stream().map(String::toCharArray).toArray(char[][]::new);
        int sum = 0;
        int removed = 1;
        while (removed > 0) {
            removed = 0;
            for (int i = 0; i < grid.length; i++) {
                char[] line = grid[i];
                for (int j = 0; j < line.length; j++) {
                    char slot = line[j];
                    int counter = 0;
                    if (slot == '@') {
                        if (i > 0) {
                            counter += checkAbove2(j, i, line, grid);
                        }
                        counter += checkSameLine2(j, line);
                        if (i < sonar.size() - 1) {
                            counter += checkBelow2(j, i, line, grid);
                        }
                        if (counter < 4) {
                            sum++;
                            grid[i][j] = 'X';
                            removed++;
                        }
                    }
                }
            }

            grid = Arrays.stream(grid)
                    .map(row -> new String(row).replace('X', '.').toCharArray())
                    .toArray(char[][]::new);
        }
        return sum+"";
    }

    private static int checkSameLine2(int j, char[] line) {
        int counter = 0;
        if (j != 0) {
            if (line[j-1] == '@' || line[j-1] == 'X') {
                counter++;
            }
        }
        if (j != line.length - 1) {
            if (line[j + 1] == '@' || line[j + 1] == 'X') {
                counter++;
            }
        }
        return counter;
    }

    private static int checkAbove2(int j, int i, char[] line, char[][] grid) {
        int counter = 0;
        if (j > 0) {
            if (grid[i-1][j-1] == '@' || grid[i-1][j-1] == 'X') {
                counter++;
            }
        }
        if (grid[i-1][j] == '@' || grid[i-1][j] == 'X') {
            counter++;
        }
        if (j < line.length-1) {
            if (grid[i-1][j+1] == '@' || grid[i-1][j+1] == 'X') {
                counter++;
            }
        }
        return counter;
    }

    private static int checkBelow2(int j, int i, char[] line, char[][] grid) {
        int counter = 0;
        if (j > 0) {
            if (grid[i+1][j-1] == '@' || grid[i+1][j-1] == 'X') {
                counter++;
            }
        }
        if (grid[i+1][j] == '@' || grid[i+1][j] == 'X') {
            counter++;
        }
        if (j < line.length - 1) {
            if (grid[i+1][j+1] == '@' || grid[i+1][j+1] == 'X') {
                counter++;
            }
        }
        return counter;
    }
}
