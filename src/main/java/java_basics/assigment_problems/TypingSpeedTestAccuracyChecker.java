public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int length = original.length();
        int matched = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // 1-based position
            }
        }

        double accuracy = ((double) matched / length) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, length, accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println("No Mismatches");
        } else {
            char originalChar = original.charAt(firstMismatchPosition - 1);
            char typedChar = typed.charAt(firstMismatchPosition - 1);
            System.out.println("First Mismatch at position " + firstMismatchPosition
                    + " ('" + originalChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
