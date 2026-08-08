import java.util.Scanner;

public class WarehouseInventoryBalancer {

    void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        // Calculate total quantity of Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        // Calculate total quantity of Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        // Compare totals
        if (totalA == totalB) {
            System.out.println("Inventory Status: Balanced");
        } else {
            System.out.println("Inventory Status: Not Balanced");
        }

        // Find highest quantity
        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        // Check Section A
        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        // Check Section B
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Highest Quantity: " + highest);
        System.out.println("Found in: " + highestSection);
        System.out.println("Index: " + highestIndex);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A:");

        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter quantities for Section B:");

        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        WarehouseInventoryBalancer obj =
                new WarehouseInventoryBalancer();

        obj.analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}