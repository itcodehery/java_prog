import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class FileOperationsClass {
  public static void main(String[] args) {
    // Directory Path
    String folderPath = "E:\\D\\Coding\\Repositories\\College_Assignments\\java_prog\\file_operations\\";

    String[] filesToCheck = { "FileOperationsClass.java", "testing.txt" };

    readMultipleFiles(folderPath, filesToCheck);
  }

  public static void readMultipleFiles(String folderPath, String[] filesToCheck) {
    File folder = new File(folderPath);

    // Check if Folder exists
    if (!folder.exists() || !folder.isDirectory()) {
      System.out.println("Couldn't open folder! Directory doesn't exist!");
      return;
    }

    File[] allFiles = folder.listFiles();

    if (allFiles == null) {
      System.out.println("Unable to list files!");
      return;
    }

    // Loop through each file to check
    for (File filename : allFiles) {
      boolean found = false;
      File selectedFile = null;

      // Search inside Directory
      for (File f : allFiles) {
        if (f.getName().equals(filename.getName())) {
          found = true;
          selectedFile = f;
          break;
        }
      }

      // Display result
      if (!found) {
        System.out.println(filename + " -> Not Found!");
        return;
      }

      try {
        System.out.println("Selected file: " + selectedFile.getName() + "\n");

        System.out.println("\n------------------------------");
        System.out.println("File Details");
        System.out.println("------------------------------");
        System.out.println("File Path: " + selectedFile.getPath());
        System.out.println("File Parent: " + selectedFile.getParent());
        System.out.println("File Canonical: " + selectedFile.getCanonicalFile());
        System.out.println("File Exists: " + selectedFile.getPath());
        System.out.println("File is a File?: " + selectedFile.isFile());
        System.out.println("File is a Directory?: " + selectedFile.isDirectory());
        System.out.println("File is Hidden?: " + selectedFile.isHidden());

        System.out.println("\n------------------------------");
        System.out.println("File Permission Details");
        System.out.println("------------------------------");
        System.out.println("Can Read?: " + selectedFile.canRead());
        System.out.println("Can Write?: " + selectedFile.canWrite());
        System.out.println("Can Execute?: " + selectedFile.canExecute());
        selectedFile.setReadable(true);
        System.out.println("File set as Readable!");
        selectedFile.setWritable(true);
        System.out.println("File set as Writable!");
        selectedFile.setExecutable(true);
        System.out.println("File set as Executable!");
        selectedFile.setReadable(true);
        selectedFile.setExecutable(false);
        selectedFile.setExecutable(false);

        System.out.println("\n------------------------------");
        System.out.println("Folder Details");
        System.out.println("------------------------------");
        System.out.println("Total Space: " + folder.getTotalSpace());
        System.out.println("Free Space: " + folder.getFreeSpace());
        System.out.println("Usable Space: " + folder.getUsableSpace() + "\n");

        System.out.println("------------------------------");
        System.out.println("--- READING FILE ---");
        System.out.println("------------------------------\n");
        FileInputStream fis = new FileInputStream(selectedFile);
        int data;
        while ((data = fis.read()) != -1) {
          System.out.print((char) data);
        }
        fis.close();
        System.out.println("------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a file name to create: ");
        String newFile = sc.next();

        File newFileFile = new File(newFile);
        if (newFileFile.createNewFile()) {
          System.out.println("File " + newFile + " successfully created!");
        } else {
          System.out.println("Couldn't create new file!");
        }

        sc.close();
      } catch (Exception e) {
        System.out.println("Couldn't open file " + filename + "!");
        return;
      }
    }
  }
}
