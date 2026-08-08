import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    void classifyWordLengths(String review) {

        // Remove punctuation and split into words
        String cleanedReview = review.replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] words = cleanedReview.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {

            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else if (length >= 9) {
                longWords++;
            }
        }

        System.out.println("\n===== WORD LENGTH PROFILE =====");
        System.out.println("Short words (1-4 letters): " + shortWords);
        System.out.println("Medium words (5-8 letters): " + mediumWords);
        System.out.println("Long words (9+ letters): " + longWords);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        MovieReviewWordLengthProfiler obj =
                new MovieReviewWordLengthProfiler();

        obj.classifyWordLengths(review);

        sc.close();
    }
}