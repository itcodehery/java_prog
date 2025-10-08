class Patient {
  int regno;

  Patient(int regno) {
    this.regno = regno;
  }

  void display() {
    System.out.println("Patient #" + this.regno);
  }
}

class Garbage {
  public static void main(String[] args) {
    Patient garbageValue = new Patient(12390);
    garbageValue.display();
    garbageValue = null;
    garbageValue.display();
    System.gc();
    System.out.println(garbageValue);
  }
}
