class MusicTrack {
    // private members
    private String trackLyrics = "Never gonna give you up...";

    private void showLyrics() {
        System.out.println("Track Lyrics: " + trackLyrics);
    }

    // default members
    int trackBPM = 128;

    void showBPM() {
        System.out.println("Track BPM: " + trackBPM);
    }

    // public members
    public String trackTitle = "Never Gonna Give You Up";

    public void showTitle() {
        System.out.println("Track Title: " + trackTitle);
    }
}

public class MusicStudio {
    public static void main(String[] args) {
        MusicTrack track = new MusicTrack();

        System.out.println("--- Demonstrating Access Modifiers in a Music Studio ---");

        System.out.println("\n1. Accessing PUBLIC members:");
        System.out.println("   - Accessing public variable 'trackTitle': " + track.trackTitle);
        System.out.print("   - Calling public method 'showTitle()': ");
        track.showTitle();

        System.out.println("\n2. Accessing DEFAULT members:");
        System.out.println("   - Accessing default variable 'trackBPM': " + track.trackBPM);
        System.out.print("   - Calling default method 'showBPM()': ");
        track.showBPM();

        System.out.println("\n3. Trying to access PRIVATE members:");
        System.out.println("   - The following lines are commented out because they would cause a compilation error.");
        System.out.println(
                "   - Private members ('trackLyrics' and 'showLyrics()') are only accessible within the 'MusicTrack' class.\n");

        // The commented lines here will cause an error:
        // System.out.println("Accessing private variable 'trackLyrics': " +
        // track.trackLyrics);
        // track.showLyrics();
    }
}
