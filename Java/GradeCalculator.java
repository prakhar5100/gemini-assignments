import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMarks = 0;
        int subjects = 5;

        // Input marks for 5 subjects
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            totalMarks += scanner.nextInt();
        }

        double percentage = (totalMarks / (subjects * 100.0)) * 100;

        System.out.println("Percentage: " + percentage + "%");

        // Grade logic
        if (percentage >= 90 && percentage <= 100) {
            System.out.println("Grade: A");
        } else if (percentage >= 80) {
            System.out.println("Grade: B");
        } else if (percentage >= 60) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D");
        }

        scanner.close();
    }
}
