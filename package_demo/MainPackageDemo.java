import shapes.*;

public class MainPackageDemo {
  public static void main(String[] args) {
    System.out.println("Hello from MainPackageDemo");
    Circle circle = new Circle();
    circle.display();
    Rectangle rect = new Rectangle();
    rect.display();
    ShapeUtils.display();
  }
}
