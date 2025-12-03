import java.io.*;
import java.util.*;

public class StudentGradeSystem {
    
    static class Student {
        int id;
        String name;
        int[] marks;
        int total;
        double average;
        String grade;

        public Student(int id, String name, int[] marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
            calculateResult();
        }

        void calculateResult() {
            total = 0;
            for (int m : marks) total += m;
            average = total / (double) marks.length;
            if (average >= 90) grade = "A";
            else if (average >= 75) grade = "B";
            else if (average >= 60) grade = "C";
            else if (average >= 50) grade = "D";
            else grade = "F";
        }

        @Override
        public String toString() {
            return id + "," + name + "," + marks[0] + "," + marks[1] + "," + marks[2];
        }

        String getDetails() {
            return String.format("ID: %d, Name: %s, Marks: %s, Total: %d, Avg: %.2f, Grade: %s",
                    id, name, Arrays.toString(marks), total, average, grade);
        }
    }

    static List<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadStudents();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Display All  2. Write Results  3. Add Student  4. Search  5. Update Marks  6. Find Topper  7. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Student s : students) System.out.println(s.getDetails());
                    break;
                case 2:
                    try (PrintWriter pw = new PrintWriter(new FileWriter("results.txt"))) {
                        for (Student s : students) pw.println(s.getDetails());
                        System.out.println("Written to results.txt");
                    } catch (IOException e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    System.out.print("ID Name Marks(3): ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int[] marks = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
                    Student s = new Student(id, name, marks);
                    students.add(s);
                    appendToFile(s);
                    break;
                case 4:
                    System.out.print("Search ID: ");
                    int sid = sc.nextInt();
                    students.stream().filter(st -> st.id == sid).findFirst()
                            .ifPresentOrElse(st -> System.out.println(st.getDetails()), () -> System.out.println("Not found"));
                    break;
                case 5:
                    System.out.print("Update ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Marks(3): ");
                    int[] newMarks = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
                    for (Student st : students) {
                        if (st.id == uid) {
                            st.marks = newMarks;
                            st.calculateResult();
                            rewriteFile();
                            System.out.println("Updated.");
                        }
                    }
                    break;
                case 6:
                    students.stream().max(Comparator.comparingInt(st -> st.total))
                            .ifPresent(top -> {
                                try (PrintWriter pw = new PrintWriter(new FileWriter("topper.txt"))) {
                                    pw.println("Topper: " + top.getDetails());
                                    System.out.println("Topper written to topper.txt");
                                } catch (IOException e) { System.out.println(e.getMessage()); }
                            });
                    break;
                case 7: return;
            }
        }
    }

    static void loadStudents() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                students.add(new Student(Integer.parseInt(p[0]), p[1], 
                        new int[]{Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4])}));
            }
        } catch (Exception e) { System.out.println("Error loading: " + e.getMessage()); }
    }

    static void appendToFile(Student s) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(s.toString());
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    static void rewriteFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) pw.println(s.toString());
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }
}
