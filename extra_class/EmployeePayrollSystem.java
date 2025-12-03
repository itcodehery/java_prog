import java.io.*;
import java.nio.file.*;
import java.util.*;

public class EmployeePayrollSystem {

    static class Employee {
        int id;
        String name;
        double basic, hra, da, pf, net;

        public Employee(int id, String name, double basic) {
            this.id = id;
            this.name = name;
            this.basic = basic;
            calc();
        }

        void calc() {
            hra = 0.2 * basic;
            da = 0.1 * basic;
            pf = 0.12 * basic;
            net = basic + hra + da - pf;
        }

        @Override
        public String toString() { return id + "," + name + "," + basic; }

        String getDetails() {
            return String.format("ID: %d, Name: %s, Basic: %.2f, Net: %.2f", id, name, basic, net);
        }
    }

    static List<Employee> employees = new ArrayList<>();
    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        loadEmployees();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Display All  2. Generate Payslips  3. Categorize  4. Update Salary  5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Employee e : employees) System.out.println(e.getDetails());
                    break;
                case 2:
                    try (PrintWriter pw = new PrintWriter(new FileWriter("payslip.txt"))) {
                        for (Employee e : employees) pw.println(e.getDetails());
                        System.out.println("Generated payslip.txt");
                    } catch (IOException e) { System.out.println(e.getMessage()); }
                    break;
                case 3:
                    try (PrintWriter high = new PrintWriter("highsalary.txt");
                         PrintWriter low = new PrintWriter("lowsalary.txt")) {
                        for (Employee e : employees) {
                            if (e.net > 50000) high.println(e.getDetails());
                            else if (e.net < 20000) low.println(e.getDetails());
                        }
                        System.out.println("Categorized into highsalary.txt and lowsalary.txt");
                    } catch (IOException e) { System.out.println(e.getMessage()); }
                    break;
                case 4:
                    System.out.print("Update ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Basic: ");
                    double nb = sc.nextDouble();
                    for (Employee e : employees) {
                        if (e.id == uid) {
                            e.basic = nb;
                            e.calc();
                            rewriteFile();
                            System.out.println("Updated.");
                        }
                    }
                    break;
                case 5: return;
            }
        }
    }

    static void loadEmployees() {
        if (!Files.exists(Paths.get(FILE_NAME))) return;
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            for (String line : lines) {
                String[] p = line.split(",");
                employees.add(new Employee(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2])));
            }
        } catch (IOException e) { System.out.println("Error loading: " + e.getMessage()); }
    }

    static void rewriteFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : employees) pw.println(e.toString());
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }
}
