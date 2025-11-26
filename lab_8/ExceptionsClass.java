import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionsClass {

  public static void main(String[] args) {
    System.out.println("Music Studio Application Started");
    String filename = "studio_data.csv";
    loadData(filename);
    System.out.println("Music Studio Application Finished");
  }

  public static void loadData(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      int lineNumber = 0;
      while ((line = br.readLine()) != null) {
        lineNumber++;
        try {
          processSong(line, lineNumber);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
          System.err.println("Error processing line " + lineNumber + ": " + e.getMessage());
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("Error: Data file not found: " + filename);
      System.err.println("Please ensure the file exists in the correct directory.");
    } catch (IOException e) {
      System.err.println("An I/O error occurred while reading the file.");
      e.printStackTrace();
    }
  }

  public static void processSong(String line, int lineNumber) {
    // Expected format: Artist,Song,Duration
    String[] parts = line.split(",");

    if (parts.length < 3) {
      throw new IllegalArgumentException(
          "Incomplete record. Expected 3 fields, found " + parts.length + ". Line content: \"" + line + "\"");
    }

    String artist = parts[0].trim();
    String song = parts[1].trim();
    String durationStr = parts[2].trim();

    if (artist.isEmpty() || song.isEmpty()) {
      throw new IllegalArgumentException("Artist or Song name cannot be empty.");
    }

    try {
      int duration = Integer.parseInt(durationStr);
      if (duration <= 0) {
        throw new IllegalArgumentException("Duration must be positive.");
      }
      System.out.println("Loaded Song: " + song + " by " + artist + " (" + duration + "s)");
    } catch (NumberFormatException e) {
      System.err.println("Error processing line " + lineNumber + ": Invalid duration format '" + durationStr
          + "'. Must be an integer.");
    }
  }
}
