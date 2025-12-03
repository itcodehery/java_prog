import java.io.FileWriter;

public class FileTestClass {
  public static void main(String[] args) {
    try (FileWriter fw = new FileWriter("data.txt")) {
      fw.write("File Writing is over");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
