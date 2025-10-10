public class Inheritance {
  public static void main(String[] args) {
    Developer dev1 = new Developer("Arden", 23900.00, "Python");
    Manager man1 = new Manager("Kartik", 49000.00, "DevOps");
    SeniorDeveloper sendev1 = new SeniorDeveloper("Arjit", 36900.00, 10, "Java");
    TeamLead tmld1 = new TeamLead("Raju", 38900.00, 10, "C", "DB Migration");

    dev1.showDetails();
    dev1.showDeveloper();

    man1.showDetails();
    man1.showManagerInfo();

    sendev1.showDetails();
    sendev1.showSeniorDeveloper();

    tmld1.showDetails();
    tmld1.showTeamLeadInfo();
  }
}

class Employee {
  String name;
  double salary;

  public void showDetails() {
    System.out.println("-----------------------");
    System.out.println("Details of Employee");
    System.out.println("Name: " + this.name);
    System.out.println("Salary: " + this.salary);
  }

  Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
  }
}

class Developer extends Employee {
  String programmingLanguage;

  public void showDeveloper() {
    System.out.println("This developer uses the " + this.programmingLanguage + " language.");
    System.out.println("-----------------------");
  }

  Developer(String name, double salary, String lang) {
    super(name, salary);
    this.programmingLanguage = lang;
  }
}

class Manager extends Employee {
  String department;

  public void showManagerInfo() {
    System.out.println("This manager manages the " + this.department + " Department.");
    System.out.println("-----------------------");
  }

  Manager(String name, double salary, String dept) {
    super(name, salary);
    this.department = dept;
  }
}

class SeniorDeveloper extends Developer {
  int teamSize;

  public void showSeniorDeveloper() {
    System.out.println("The developer is of rank: Senior and is a part of a team of size " + this.teamSize);
    System.out.println("-----------------------");
  }

  SeniorDeveloper(String name, double salary, int teamSize, String progLang) {
    super(name, salary, progLang);
    this.teamSize = teamSize;
  }
}

class TeamLead extends SeniorDeveloper {
  String projectName;

  public void showTeamLeadInfo() {
    System.out.println("This developer is also the team lead and manages the " + this.projectName + " project.");
    System.out.println("-----------------------");
  }

  TeamLead(String name, double salary, int teamSize, String progLang, String projectName) {
    super(name, salary, teamSize, progLang);
    this.projectName = projectName;
  }
}
