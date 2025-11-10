abstract class Appliance {
  abstract void turnOn();

  void status() {
    System.out.println("Appliance is ready");
  }
}

class Fan extends Appliance {
  @Override
  void turnOn() {
    System.out.println("Fan is spinning");
  }
}

public class AbstractMain {
  public static void main(String[] args) {
    Appliance a = new Fan();
    a.turnOn();
    a.status();
  }
}
