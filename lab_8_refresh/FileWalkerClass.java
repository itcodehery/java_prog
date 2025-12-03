import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileWalkerClass {
  public static void main(String[] args) {
    Path dir = Paths.get("Studio");

    System.out.println("--- All Files ---");
    try (Stream<Path> paths = Files.walk(dir)) {
      paths.filter(Files::isRegularFile)
          .forEach(System.out::println);
    } catch (IOException e) {
      System.err.println("Error while walking the file tree: " + e.getMessage());
    }

    System.out.println("--- Text Files ---");
    try (Stream<Path> paths = Files.find(dir, 2, (path, attr) -> path.toString().endsWith(".txt"))) {
      paths.forEach(System.out::println);
    } catch (IOException e) {
      System.err.println("Error while finding text files: " + e.getMessage());
    }

    System.out.println("--- Error Test ---");
    try {
      Files.walk(Paths.get("Invalid_Path"));
    } catch (IOException e) {
      System.err.println("File Operation Error (Expected): " + e.getMessage());
    } catch (RuntimeException e) {
      System.err.println("Runtime Error: " + e.getMessage());
    }
  }
}
