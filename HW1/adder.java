import java.util.Scanner;
import java.util.InputMismatchException;

public class adder {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;

        while (true) {
            try {
                System.out.print("Enter the first integer: ");
                num1 = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); 
            }
        }

        while (true) {
            try {
                System.out.print("Enter the second integer: ");
                num2 = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); 
            }
        }

        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        scanner.close();
    }
}
