// Interface for Artists, Instrumentalists and Music Producers
interface Recordable {
  void record();
}

// Interface for Music Producers only
interface Masterable {
  void mastering();
} 

class Artist implements Recordable {
  String name;
  String genre;

  Artist(String name, String genre) {
    this.name = name;
    this.genre = genre;
  }

  public void record() {
    System.out.println("Artist: "+ this.name + " > Recording in session...");
  }
}

class Instrumentalist implements Recordable {
  String name;
  String instrument;

  Instrumentalist (String name, String instrument) {
    this.name = name;
    this.instrument = instrument;
  }

  public void record() {
    System.out.println("Instrumentalist: "+this.name +" > Recording in session...");
  }
}

class MusicProducer implements Recordable, Masterable {
  String name;
  String forArtist;
  String genre;

  MusicProducer(String name, String forArtist, String genre) {
    this.name = name;
    this.forArtist = forArtist;
    this.genre = genre;
  }

  public void record() {
    System.out.println("Music Producer: "+ this.name + " > Recording in session for Artist : " + this.forArtist + "...");
  }

  public void mastering() {
    System.out.println(this.name + " is currently mastering a song for artist: " + this.forArtist + " in the genre: " + this.genre);
  }
}


public class WestbrookStudio {
  public static void main(String[] args) {
    Recordable artist = new  Artist("Kendrick Lamar","Hip-hop");
    Recordable instmtlst = new Instrumentalist("Common","Synthesizer");
    MusicProducer mscprod = new MusicProducer("Kanye West","Common","Alternative Hip-hop");

    artist.record();
    instmtlst.record();
    mscprod.record();
    mscprod.mastering();
  }
}
