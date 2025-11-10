class Student {
    String name;
    int age;

    public Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Ravi", 22);
        s.display();
    }
}
