import java.util.Scanner;
public class Range {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 10: ");
        int number = scan.nextInt();
        assert (number >= 0 || number <= 10) : "The entered number is out of range";
        System.out.println("You entered " + number);
        scan.close();
    }
}
