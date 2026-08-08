import java.util.Scanner;

public class ShortestLongestWordFinder {

    String[] findShortestAndLongestWord(String text) {

        // Remove punctuation and split into words
        String cleanedText = text.replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] words = cleanedText.trim().split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {

            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }

            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence or paragraph: ");
        String text = sc.nextLine();

        ShortestLongestWordFinder obj =
                new ShortestLongestWordFinder();

        String[] result = obj.findShortestAndLongestWord(text);

        System.out.println("\n===== WORD ANALYSIS =====");
        System.out.println("Shortest Word: " + result[0]);
        System.out.println("Length: " + result[0].length());

        System.out.println("Longest Word: " + result[1]);
        System.out.println("Length: " + result[1].length());

        sc.close();
    }
}