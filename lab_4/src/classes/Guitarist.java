package classes;

import enums.Genre;
import enums.GuitarType;
import interfaces.Artist;
import interfaces.Recordable;

import java.util.Arrays;
import java.util.Optional;

public class Guitarist implements Artist, Recordable {

    private String name;
    private Genre genre;
    private int artistRank;
    private GuitarType guitarType;
    public Optional<String> lastRecording;
    private Session[] sessions = new Session[0];


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
        this.lastRecording = Optional.empty();
    }

    public int getArtistRank() {
        return artistRank;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    void play() {
        System.out.println(
                name + " is playing their " + getGuitarName(guitarType) + " Guitar"
        );
    }

    String getGuitarName(GuitarType type) {
        switch (type) {
            case Bass:
                return "Bass";
            case Classical:
                return "Classical";
            case Electric:
                return "Electric";
            case Folk:
                return "Folk";
            default:
                return "Unknown";
        }
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

    public void addSession(Session session) {
        Session[] newArr = Arrays.copyOf(sessions, sessions.length + 1);
        newArr[sessions.length] = session;
        sessions = newArr;
    }
}
