class Data {
  int value;
  boolean available = false;

  synchronized void produce(int v) {
      while (available)
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("InterruptedException error!");
        }
    value = v;
    available = true;
    notify();
  }

  synchronized void consume() {
      while (!available)
        try {
          wait();
        } catch (InterruptedException e) {
          System.out.println("InterruptedException error!");
        }
    System.out.println("Consumed: " + value);
    available = false;
    notify();
  }
}

public class InterthreadMain {
  public static void main(String[] args) {
    Data d = new Data();
    new Thread(() -> d.produce(10)).start();
    new Thread(() -> d.consume()).start();
  }
}
