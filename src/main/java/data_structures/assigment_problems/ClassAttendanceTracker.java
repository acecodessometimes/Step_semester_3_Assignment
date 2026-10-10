package data_structures.assigment_problems;

public class ClassAttendanceTracker {
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    static void printSummary(int[] days) {
        int[] summary = attendanceSummary(days);
        System.out.println("Present: " + summary[0] + ", Longest streak: " + summary[1]);
    }

    public static void main(String[] args) {
        printSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        printSummary(new int[]{0, 0, 0});
    }
}
