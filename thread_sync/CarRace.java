class RaceTrack {
  public static String winner = null;

  // Thread Synchronization
  public synchronized void finish(String carName) {
    if (winner == null) {
      winner = carName;
      System.out.println(carName + " WINS the race!");
    } else {
      System.out.println(carName + " finished the race. ");
    }
  }
}

class Car extends Thread {
  private String carName;
  private RaceTrack track;

  Car(String name, RaceTrack raceTrack) {
    carName = name;
    track = raceTrack;
  }

  public void run() {
    System.out.println(carName + " has started racing!");
    for (int i = 1; i <= 10; i++) {
      System.out.println(carName + " is at position " + (i * 10) + "%");
      try {
        Thread.sleep((int) (Math.random() * 300 + 100));
      } catch (InterruptedException e) {
        System.out.println(carName + " had a technical issue!");
      }
    }
    track.finish(carName);
  }
}

public class CarRace {
  public static void main(String[] args) {
    RaceTrack track = new RaceTrack();

    Car car1 = new Car("Arden's Car", track);
    Car car2 = new Car("Darshan's Car", track);
    Car car3 = new Car("Hari's Car", track);

    car1.setPriority(Thread.MIN_PRIORITY);
    car2.setPriority(Thread.NORM_PRIORITY);
    car3.setPriority(Thread.MAX_PRIORITY);

    car1.start();
    car2.start();
    car3.start();
  }
}
