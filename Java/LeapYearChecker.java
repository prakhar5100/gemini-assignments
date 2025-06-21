import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Leap year logic: divisible by 4 but not 100 unless also divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("The year is a Leap Year.");
        } else {
            System.out.println("The year is NOT a Leap Year.");
        }

        scanner.close();
    }
}
