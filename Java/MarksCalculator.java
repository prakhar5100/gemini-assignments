import java.util.Scanner;

public class MarksCalculator {
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

        System.out.println("Total Marks = " + totalMarks);
        System.out.println("Percentage = " + percentage + "%");

        scanner.close();
    }
}
