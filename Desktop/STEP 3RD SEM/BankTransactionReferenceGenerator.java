import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String rest = reference.substring(3);

        return bankCode + rest;
    }

    String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: non-letter bank code";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract parts
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        // Format date from ddMMyy to dd/MM/yy
        String formattedDate = date.substring(0, 2)
                + "/"
                + date.substring(2, 4)
                + "/"
                + date.substring(4, 6);

        // Build formatted output using StringBuilder
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(formattedDate);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        BankTransactionReferenceGenerator obj =
                new BankTransactionReferenceGenerator();

        String normalized = obj.normalizeReference(raw);

        System.out.println(obj.validateAndFormat(normalized));

        sc.close();
    }
}