import java.util.Scanner;

public class VIPCustomerIdentification {

    String validateCustomerId(String customerId) {

        if (customerId.startsWith("VIP-")) {
            return "VIP Customer";
        }

        return "Regular Customer";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();

        VIPCustomerIdentification obj =
                new VIPCustomerIdentification();

        String result = obj.validateCustomerId(customerId);

        System.out.println(result);

        sc.close();
    }
}
