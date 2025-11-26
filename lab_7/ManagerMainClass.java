
import java.util.ArrayList;
import java.util.List;

class Track {
  private String title;
  private String artist;
  private int durationInSeconds;
  private String genre;

  public Track(String title, String artist, int durationInSeconds, String genre) {
    this.title = title;
    this.artist = artist;
    this.durationInSeconds = durationInSeconds;
    this.genre = genre;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public int getDurationInSeconds() {
    return durationInSeconds;
  }

  public String getGenre() {
    return genre;
  }

  @Override
  public String toString() {
    return "Track['" + title + "' by " + artist + ", Genre: " + genre + ", Duration: " + durationInSeconds + "s]";
  }
}

class MusicStudioManager {
  private List<Track> trackCatalog;
  private List<String> uniqueGenres;

  public MusicStudioManager() {
    this.trackCatalog = new ArrayList<>();
    this.uniqueGenres = new ArrayList<>();
  }

  public void addTrack(Track track) {
    trackCatalog.add(track);

    // Manually ensure genre is unique before adding
    if (!uniqueGenres.contains(track.getGenre())) {
      uniqueGenres.add(track.getGenre());
    }
  }

  public void listAllTracks() {
    System.out.println("--- Full Track Catalog ---");
    for (Track track : trackCatalog) {
      System.out.println(track);
    }
  }

  public void listUniqueGenres() {
    System.out.println("\n--- Unique Music Genres ---");
    for (String genre : uniqueGenres) {
      System.out.println(genre);
    }
  }

  public void findTracksByArtist(String artist) {
    System.out.println("\n--- Tracks by " + artist + " ---");
    List<Track> artistTracks = new ArrayList<>();
    for (Track track : trackCatalog) {
      if (track.getArtist().equals(artist)) {
        artistTracks.add(track);
      }
    }

    if (artistTracks.isEmpty()) {
      System.out.println("No tracks found for artist: " + artist);
    } else {
      for (Track track : artistTracks) {
        System.out.println(track);
      }
    }
  }

  public void calculateAndPrintTotalDuration() {
    int totalSeconds = 0;
    for (Track track : trackCatalog) {
      totalSeconds += track.getDurationInSeconds();
    }
    long minutes = totalSeconds / 60;
    long seconds = totalSeconds % 60;
    System.out.println("\n--- Library Statistics ---");
    System.out.printf("Total Library Duration: %d minutes and %d seconds (%d total seconds).\n", minutes, seconds,
        totalSeconds);
  }
}

public class ManagerMainClass {
  public static void main(String[] args) {
    MusicStudioManager studio = new MusicStudioManager();

    studio.addTrack(new Track("Midnight Groove", "The Jazz Cats", 245, "Jazz"));
    studio.addTrack(new Track("Sunrise", "Acoustic Moods", 180, "Acoustic"));
    studio.addTrack(new Track("City Lights", "The Jazz Cats", 310, "Jazz"));
    studio.addTrack(new Track("Ocean Drive", "Synth Wave", 205, "Electronic"));
    studio.addTrack(new Track("Lost in Thought", "Acoustic Moods", 215, "Acoustic"));

    studio.listAllTracks();
    studio.listUniqueGenres();
    studio.findTracksByArtist("The Jazz Cats");
    studio.findTracksByArtist("Unknown Artist");

    studio.calculateAndPrintTotalDuration();
  }
}
