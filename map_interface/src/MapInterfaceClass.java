package src.map_interface;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Comparator;

class StudentMarks {
  private int cia1, cia2, cia3;

  public StudentMarks(int cia1, int cia2, int cia3) {
    this.cia1 = cia1;
    this.cia2 = cia2;
    this.cia3 = cia3;
  }

  public int getCia1() {
    return cia1;
  }

  public int getCia2() {
    return cia2;
  }

  public int getCia3() {
    return cia3;
  }

  public int getTotalMarks() {
    return cia1 + cia2 + cia3;
  }

  @Override
  public String toString() {
    return "CIA1: " + cia1 + ", CIA2: " + cia2 + ", CIA3: " + cia3 + ", Total: " + getTotalMarks();
  }
}

public class MapInterfaceClass {
  public static void main(String[] args) {
    Map<String, StudentMarks> studentData = new TreeMap<>();
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\n--- Student Marks Management System ---");
      System.out.println("1. Add Student Marks");
      System.out.println("2. Update Student Marks");
      System.out.println("3. Retrieve Student Marks");
      System.out.println("4. Display All Students' Marks (Sorted by Reg No)");
      System.out.println("5. Find Topper");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          addStudent(scanner, studentData);
          break;
        case 2:
          updateStudent(scanner, studentData);
          break;
        case 3:
          retrieveStudent(scanner, studentData);
          break;
        case 4:
          displayAllStudents(studentData);
          break;
        case 5:
          findTopper(studentData);
          break;
        case 6:
          System.out.println("Exiting program.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 6);

    scanner.close();
  }

  private static void addStudent(Scanner scanner, Map<String, StudentMarks> studentData) {
    System.out.print("Enter Register Number: ");
    String regNo = scanner.nextLine();
    if (studentData.containsKey(regNo)) {
      System.out.println("Error: Student with this Register Number already exists.");
      return;
    }
    System.out.print("Enter CIA1 Marks: ");
    int cia1 = scanner.nextInt();
    System.out.print("Enter CIA2 Marks: ");
    int cia2 = scanner.nextInt();
    System.out.print("Enter CIA3 Marks: ");
    int cia3 = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    studentData.put(regNo, new StudentMarks(cia1, cia2, cia3));
    System.out.println("Student marks added successfully.");
  }

  private static void updateStudent(Scanner scanner, Map<String, StudentMarks> studentData) {
    System.out.print("Enter Register Number to update: ");
    String regNo = scanner.nextLine();
    if (!studentData.containsKey(regNo)) {
      System.out.println("Error: Student with this Register Number not found.");
      return;
    }

    System.out.print("Enter new CIA1 Marks: ");
    int cia1 = scanner.nextInt();
    System.out.print("Enter new CIA2 Marks: ");
    int cia2 = scanner.nextInt();
    System.out.print("Enter new CIA3 Marks: ");
    int cia3 = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    studentData.put(regNo, new StudentMarks(cia1, cia2, cia3));
    System.out.println("Student marks updated successfully.");
  }

  private static void retrieveStudent(Scanner scanner, Map<String, StudentMarks> studentData) {
    System.out.print("Enter Register Number to retrieve: ");
    String regNo = scanner.nextLine();
    StudentMarks marks = studentData.get(regNo);
    if (marks == null) {
      System.out.println("Error: Student with this Register Number not found.");
    } else {
      System.out.println("Marks for " + regNo + ": " + marks);
    }
  }

  private static void displayAllStudents(Map<String, StudentMarks> studentData) {
    if (studentData.isEmpty()) {
      System.out.println("No student data available.");
      return;
    }
    System.out.println("\n--- All Student Marks ---");
    for (Map.Entry<String, StudentMarks> entry : studentData.entrySet()) {
      System.out.println("Reg No: " + entry.getKey() + " | Marks: " + entry.getValue());
    }
  }

  private static void findTopper(Map<String, StudentMarks> studentData) {
    if (studentData.isEmpty()) {
      System.out.println("No student data available to determine a topper.");
      return;
    }

    Map.Entry<String, StudentMarks> topper = null;
    int maxTotal = -1;

    for (Map.Entry<String, StudentMarks> entry : studentData.entrySet()) {
      int currentTotal = entry.getValue().getTotalMarks();
      if (currentTotal > maxTotal) {
        maxTotal = currentTotal;
        topper = entry;
      }
    }

    if (topper != null) {
      System.out.println("\n--- Topper ---");
      System.out.println("Register Number: " + topper.getKey());
      System.out.println("Marks: " + topper.getValue());
    }
  }
}
