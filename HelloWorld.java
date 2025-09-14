import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    try {
      System.out.print("Enter a number: ");
      int number = reader.nextInt();

      System.out.println("You entered: " + number);}

    catch (java.util.InputMismatchException e) {
      System.out.println("Couldn't parse integer!");
    }
  }
}
