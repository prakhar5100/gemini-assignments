import java.util.Scanner;

public class GreatestOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        System.out.print("Enter third number: ");
        int c = scanner.nextInt();

        // Using if-else to find the greatest
        if (a >= b && a >= c) {
            System.out.println("Greatest number is: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("Greatest number is: " + b);
        } else {
            System.out.println("Greatest number is: " + c);
        }

        scanner.close();
    }
}
