class MyThread implements Runnable {
  public synchronized void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Printing..." + i);
    }
  }
}

class NewClass {
  public static void main(String[] args) {
    MyThread x = new MyThread();
    MyThread y = new MyThread();
    Thread thread1 = new Thread(x);
    Thread thread2 = new Thread(y);
    thread1.start();
    thread2.start();
  }
}
