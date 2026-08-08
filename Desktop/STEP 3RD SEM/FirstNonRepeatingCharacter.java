import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    char findFirstNonRepeatingChar(String text) {

        // Store frequency of each character
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency.get(ch) == 1) {
                return ch;
            }
        }

        // Return '\0' if no non-repeating character exists
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        FirstNonRepeatingCharacter obj =
                new FirstNonRepeatingCharacter();

        char result = obj.findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}