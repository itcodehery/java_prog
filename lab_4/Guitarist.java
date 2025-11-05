package classes;

import interfaces.Artist;
import interfaces.Genre;
import interfaces.Recordable;

import java.util.Optional;

public class Guitarist implements Artist, Recordable {
    GuitarType guitarType;
    Optional<String> lastRecording;

    public Guitarist(
        String name,
        Genre genre,
        int artistRank,
        GuitarType typeOfGuitar
    ) {
        this.name = name;
        this.genre = genre;
        this.artistRank = artistRank;
        this.guitarType = typeOfGuitar;
    }

    void play() {
        System.out.println(name + "is playing their " + )
    }

    String getGuitarName(GuitarType type) {
        return switch (type) {
            case GuitarType.Bass: "Bass";
          case GuitarType.Classical: "Classical";
          default: "Unknown";
        }
    }

    @Override
    public void displaySessions() {
        for (Session i : sessions) {
            System.out.println("------------------------");
            System.out.println("ID: #" + i.sessionId);
            System.out.println("------------------------");
            System.out.println("Date: " + i.day + "/" + i.month + "/" + i.year);
            System.out.println("");
        }
    }
}
