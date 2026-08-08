import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative comparison
    boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive comparison
    boolean isPalindromeRecursive(String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Array reversal
    boolean isPalindromeArray(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return String.valueOf(original).equals(String.valueOf(reversed));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        PalindromeChecker obj = new PalindromeChecker();

        boolean iterativeResult =
                obj.isPalindromeIterative(text);

        boolean recursiveResult =
                obj.isPalindromeRecursive(text, 0, text.length() - 1);

        boolean arrayResult =
                obj.isPalindromeArray(text);

        System.out.println("\n===== PALINDROME CHECK RESULTS =====");

        System.out.println("Iterative Approach: " + iterativeResult);
        System.out.println("Recursive Approach: " + recursiveResult);
        System.out.println("Array Reversal Approach: " + arrayResult);

        // Check that all three approaches agree
        if (iterativeResult == recursiveResult
                && recursiveResult == arrayResult) {

            System.out.println("All three approaches agree.");

        } else {

            System.out.println("Error: Approaches do not agree.");
        }

        sc.close();
    }
}