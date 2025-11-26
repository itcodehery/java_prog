import java.util.Scanner;
import java.io.*;

public class Except {
  public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    System.out.println("Enter a file name: ");
    String filename = s1.next();

    // Read a file
    String root = System.getProperty("user.dir");
    String path = root + "\\" + filename;

    // Use FileReader to extract file from path
    try {
      FileReader fr = new FileReader(path);
      int i;
      while ((i = fr.read()) != -1) {
        System.out.print((char) i);
      }
      fr.close();
    } catch (IOException ex) {
      System.err.println("IO Exception occurred you idiot!");
    }
    s1.close();
  }
}
