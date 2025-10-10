public class FinalClass {
  static int common_int = 0;
  static final String helloWorld = "Hello World";

  final void displayHelloName() {
    System.out.println("Hello Arden!");
  }

  public FinalClass() {}
}

public class Finalizer extends FinalClass {
  public static void changeCommonInt(int val) {
    common_int = val;
  }

  @Override
  final void displayHelloName() {
    System.out.println("Hello Hari!");
  }

  public static void main(String[] args) {
    System.out.println(helloWorld);
    changeCommonInt(10);
    System.out.println(common_int);
  }    
}
