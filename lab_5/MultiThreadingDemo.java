// A Music Studio themed demonstration of multi-threading concepts.

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

        // After mixing, the studio becomes available for recording again.
        isAvailableForRecording = true;
        notifyAll(); 
        return track;
    }

    public synchronized void recordTrack(String track) {
        while (!isAvailableForRecording) {
            try {
                System.out.println("Musician is waiting for the studio to be free.");
                wait(); // Releases the lock and waits for the engineer to finish mixing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Musician thread interrupted.");
            }
        }

        // The studio is available. The musician can record.
        this.track = track;
        System.out.println("Musician has recorded: '" + track + "'");

        // After recording, the studio is no longer available for recording until the
        // track is mixed.
        isAvailableForRecording = false;
        notifyAll(); // Notify the waiting sound engineer that there is a new track.
    }
}

// The Musician thread, which produces tracks.
class Musician extends Thread {
    private final RecordingStudio studio;
    private final String[] tracksToRecord = {
            "Vocal Melody",
            "Guitar Riff",
            "Bass Line",
            "Drum Beat",
            "Session Finished" // Sentinel value to end the session
    };

    public Musician(RecordingStudio studio) {
        this.studio = studio;
    }

    @Override
    public void run() {
        for (String track : tracksToRecord) {
            studio.recordTrack(track);
            try {
                // Simulate time taken to prepare for the next recording
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Musician thread interrupted during recording session.");
            }
        }
    }
}

// The SoundEngineer, which consumes and processes tracks.
class SoundEngineer implements Runnable {
    private final RecordingStudio studio;

    public SoundEngineer(RecordingStudio studio) {
        this.studio = studio;
    }

    @Override
    public void run() {
        for (String track = studio.mixTrack(); !track.equals("Session Finished"); track = studio.mixTrack()) {
            try {
                // Simulate time to mix the track
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Sound Engineer thread interrupted during mixing.");
            }
        }
        // The loop terminates after "Session Finished" is received from mixTrack().
    }
}

// Main class to run the music studio demo
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
