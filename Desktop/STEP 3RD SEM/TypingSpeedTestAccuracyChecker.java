import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy =
                ((double) matchedCharacters / original.length()) * 100;

        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatch == -1) {
            System.out.println("No mismatches found. Perfect typing!");
        } else {
            System.out.println(
                    "First mismatch position: " + (firstMismatch + 1));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        if (original.length() != typed.length()) {
            System.out.println(
                    "Error: Both strings must have equal length.");
        } else {
            TypingSpeedTestAccuracyChecker obj =
                    new TypingSpeedTestAccuracyChecker();

            obj.checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}