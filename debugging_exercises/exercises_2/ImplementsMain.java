interface Printable {
  void show();
}

interface Displayable {
  void show();
}

class Output implements Printable, Displayable {
  public void show() {
    System.out.println("Showing output");
  }
}

public class ImplementsMain {
  public static void main(String[] args) {
    Output o = new Output();
    o.show();
  }
}
