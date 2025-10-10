import java.util.Scanner;

class ScannerTest {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String name = scanner.nextLine();

    System.out.println("Enter your mark: ");
    int mark = scanner.nextInt();

    System.out.println("You are " + name + " and you have scored " + mark + " marks!");
  }
}
