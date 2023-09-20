import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class arrayIndex {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int array [] = new int[100];
        
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000); 
        }
        while(true){
            try {
                System.out.print("Enter the index (0-99): ");
                int index = scanner.nextInt();

                if (index >= 0 && index < array.length) {
                    System.out.println("Element at index " + index + " is: " + array[index]);
                } else {
                    System.out.println("Out of Bounds");
                }
               // break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();

            } 
        }
    }
}
