import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {

    void checkDuplicateSeats(int[] seatNumbers) {

        boolean duplicateFound = false;

        System.out.println("\nDuplicate seat numbers:");

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean alreadyPrinted = false;

            for (int j = 0; j < i; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println(seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicate seat numbers found.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] seatNumbers = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seatNumbers[i] = sc.nextInt();
        }

        ExamHallSeatDuplicationChecker obj =
                new ExamHallSeatDuplicationChecker();

        obj.checkDuplicateSeats(seatNumbers);

        sc.close();
    }
}