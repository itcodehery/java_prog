public class CommandLine {
  public static void main(String args[]) {
    if (args.length != 0 && args.length == 2) {
      System.out.println("------------------");
      System.out.println("Student Name: "+ args[0]);
      System.out.println("Student Marks: " + args[1]);
      int marks = Integer.parseInt(args[1]);
      if (marks > 40) {
        System.out.println("Student has passed!");
      } else {
        System.out.println("Student has failed!");
      }
      System.out.println("------------------");
    } else {
      System.out.println("Invalid arguments!");
    }
  }
}
