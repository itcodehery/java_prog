class Vehicle {
  public int speed = 50;
}

class Car extends Vehicle {
  void showSpeed() {
    System.out.println("Speed: " + speed);
  }
}

public class VehicleMain {
  public static void main(String[] args) {
    Car c = new Car();
    c.showSpeed();
  }
}
