interface Recordable {
  void record();
}

class Artist implements Recordable {
  String name;
  String genre;

  Artist(String name, String genre) {
    this.name = name;
    this.genre = genre;
  }

  public void record() {
    System.out.println("Artist: " + this.name + " > Recording in session...");
  }
}

class Instrumentalist implements Recordable {
  String name;
  String instrument;

  Instrumentalist(String name, String instrument) {
    this.name = name;
    this.instrument = instrument;
  }

  public void record() {
    System.out.println("Instrumentalist: " + this.name + " > Recording in session...");
  }
}

public class KonpekiStudio {
  public static void main(String[] args) {
    Recordable artist = new Artist("Kendrick Lamar", "Hip-hop");
    Recordable instmtlst = new Instrumentalist("Common", "Synthesizer");

    artist.record();
    instmtlst.record();
  }
}
