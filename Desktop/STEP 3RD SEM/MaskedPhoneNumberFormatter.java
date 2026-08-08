import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    String maskPhoneNumber(String phone) {

        // Validate exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked number using StringBuilder
        StringBuilder maskedNumber = new StringBuilder();

        maskedNumber.append("XXXXXX");
        maskedNumber.append("-");
        maskedNumber.append(phone.substring(6));

        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        MaskedPhoneNumberFormatter obj = new MaskedPhoneNumberFormatter();

        System.out.println(obj.maskPhoneNumber(phone));

        sc.close();
    }
}
