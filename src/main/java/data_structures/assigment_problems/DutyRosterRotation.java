package data_structures.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, int k) {
        if (names.length == 0) {
            return new String[0];
        }
        int rotation = k % names.length;
        String[] rotated = new String[names.length];
        for (int index = 0; index < names.length; index++) {
            rotated[(index + rotation) % names.length] = names[index];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
