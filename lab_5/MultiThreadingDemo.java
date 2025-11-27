class RecordingStudio {
  private String track;
  private boolean isAvailableForRecording = true;

  public synchronized String mixTrack() {
    while (isAvailableForRecording) {
      try {
        System.out.println("Sound Engineer is waiting for a new track.");
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Sound Engineer thread interrupted.");
      }
    }

    System.out.println("Sound Engineer is mixing: '" + track + "'");

    isAvailableForRecording = true;
    notifyAll();
    return track;
  }

  public synchronized void recordTrack(String track) {
    while (!isAvailableForRecording) {
      try {
        System.out.println("Musician is waiting for the studio to be free.");
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Musician thread interrupted.");
      }
    }

    this.track = track;
    System.out.println("Musician has recorded: '" + track + "'");

    isAvailableForRecording = false;
    notifyAll();
  }
}

class Musician extends Thread {
  private final RecordingStudio studio;
  private final String[] tracksToRecord = {
      "Vocal Melody",
      "Guitar Riff",
      "Bass Line",
      "Drum Beat",
      "Session Finished"
  };

  public Musician(RecordingStudio studio) {
    this.studio = studio;
  }

  @Override
  public void run() {
    for (String track : tracksToRecord) {
      studio.recordTrack(track);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Musician thread interrupted during recording session.");
      }
    }
  }
}

class SoundEngineer implements Runnable {
  private final RecordingStudio studio;

  public SoundEngineer(RecordingStudio studio) {
    this.studio = studio;
  }

  @Override
  public void run() {
    for (String track = studio.mixTrack(); !track.equals("Session Finished"); track = studio.mixTrack()) {
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Sound Engineer thread interrupted during mixing.");
      }
    }
  }
}

public class MultiThreadingDemo {
  public static void main(String[] args) {
    System.out.println("Music Studio session starting.");

    RecordingStudio sharedStudio = new RecordingStudio();

    Musician musician = new Musician(sharedStudio);
    musician.setName("Artist-Producer");

    SoundEngineer engineerRunnable = new SoundEngineer(sharedStudio);
    Thread engineerThread = new Thread(engineerRunnable);
    engineerThread.setName("Sound-Engineer");

    System.out.println("Starting Musician and Sound Engineer threads.");

    musician.start();
    engineerThread.start();

    try {
      musician.join();
      System.out.println("Musician has finished recording.");
      engineerThread.join();
      System.out.println("Sound Engineer has finished mixing.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Music Studio session finished.");
  }
}
