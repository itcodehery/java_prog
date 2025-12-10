// class TestingThread extends Thread {
//   private int counter;
//
//   public void run() {
//     for (int i = 0; i < 10; i++) {
//       counter += 1;
//       System.out.println(counter);
//     }
//   }
// }

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;

public class EtePracticeClass {
  public static void readFile(File openFile) {
    try (BufferedReader br = new BufferedReader(new FileReader(openFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("Some IO Exception occurred!");
      e.printStackTrace();
    }
  }

  public static void writeToFile(File openFile) {
    String line;
    Scanner sc = new Scanner(System.in);
    System.out.println("What do you want to write: ");
    line = sc.nextLine();
    System.out.println("\nThe line: " + line + "\n");

    try (PrintWriter pw = new PrintWriter(new FileWriter(openFile))) {
      // pw.println(line);
      pw.append(line);
    } catch (IOException e) {
      System.out.println("Something went wrong da");
      e.printStackTrace();
    }
    sc.close();
  }

  public static void main(String[] args) {
    File openFile = new File("sample.txt");
    // Read the file
    readFile(openFile);
    // Write to the file
    writeToFile(openFile);
    // Read the file
    readFile(openFile);
  }
}
