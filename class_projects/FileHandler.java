import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileHandler {
  public static void main(String[] args) {
    try (var reader = new BufferedReader(new FileReader("NewClass.java"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Failed to fetch file! : " + e);
    }
  }
}
