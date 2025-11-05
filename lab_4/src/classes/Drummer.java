package classes;

import enums.DrumKitType;
import enums.Genre;
import interfaces.Artist;
import interfaces.Recordable;

import java.util.Arrays;
import java.util.Optional;

public class Drummer implements Artist, Recordable {

    private String name;
    private Genre genre;
    private int artistRank;
    private DrumKitType drumKitType;
    public Optional<String> lastRecording;
    private Session[] sessions = new Session[0];

    public Drummer(
            String name,
            Genre genre,
            int artistRank,
            DrumKitType drumKitType
    ) {
        this.name = name;
        this.genre = genre;
        this.artistRank = artistRank;
        this.drumKitType = drumKitType;
        this.lastRecording = Optional.empty();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Genre getGenre() {
        return genre;
    }

    @Override
    public int getArtistRank() {
        return artistRank;
    }

    public void play() {
        System.out.println(name + " is playing the " + drumKitType + " drums.");
    }

    @Override
    public void displaySessions() {
        System.out.println("\n------------------------");
        System.out.println("Listing all sessions for " + name);
        System.out.println("------------------------");
        for (Session i : sessions) {
            System.out.println("------------------------");
            System.out.println("ID: #" + i.sessionId);
            System.out.println("------------------------");
            System.out.println("Date: " + i.day + "/" + i.month + "/" + i.year);
            System.out.println("Artist: " + name);
        }
        System.out.println("------------------------");
    }

    @Override
    public void addSession(Session session) {
        Session[] newArr = Arrays.copyOf(sessions, sessions.length + 1);
        newArr[sessions.length] = session;
        sessions = newArr;
    }
}
