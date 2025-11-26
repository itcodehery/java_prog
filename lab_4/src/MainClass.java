import classes.Drummer;
import classes.Guitarist;
import classes.Session;
import enums.DrumKitType;
import enums.Genre;
import enums.GuitarType;

public class MainClass {

  public static void main(String[] args) {
    Guitarist bro = new Guitarist(
        "Darshan",
        Genre.Folk,
        2,
        GuitarType.Classical);

    if (bro.lastRecording.isPresent()) {
      System.out.println(
          bro.getName() + " was last recording " + bro.lastRecording.get());
    } else {
      System.out.println(bro.getName() + " has no recordings yet.");
    }

    Session newSession = new Session("sess1", 1, 1, 2024, 10, 30);
    bro.addSession(newSession);
    bro.displaySessions();

    Drummer drummer = new Drummer("John", Genre.Rock, 1, DrumKitType.Acoustic);
    drummer.play();
    Session drumSession = new Session("sess2", 2, 2, 2024, 14, 0);
    drummer.addSession(drumSession);
    drummer.displaySessions();
  }
}
