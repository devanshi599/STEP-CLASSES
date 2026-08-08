import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        String rest = code.substring(3);

        return publisherCode + rest;
    }

    String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract parts
        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Build formatted output using StringBuilder
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = sc.nextLine();

        LibraryISBNNormalizerValidator obj =
                new LibraryISBNNormalizerValidator();

        String normalized = obj.normalizeCode(raw);

        System.out.println(obj.validateAndFormat(normalized));

        sc.close();
    }
}