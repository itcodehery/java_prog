// class #1
class Artist {
  public static enum Genre {
    Pop, Rock, Electronic, Jazz, Dance
  }

  public static String genre_to_string(Genre genre) {
    return switch (genre) {
      case Pop -> "Pop";
      case Dance -> "Dance";
      case Electronic -> "Electronic";
      case Jazz -> "Jazz";
      case Rock -> "Rock";
    };
  }

  public static Genre string_to_genre(String string) {
    return switch (string) {
      case "Pop" -> Genre.Pop;
      case "Rock" -> Genre.Rock;
      case "Dance" -> Genre.Dance;
      case "Jazz" -> Genre.Jazz;
      case "Electronic" -> Genre.Electronic;
      default -> Genre.Pop;
    };
  }

  StringBuffer name;
  Genre genre;
  Song[] songs;

  // Default Constructor
  Artist() {
  }

  // Parameterized Constructor
  Artist(StringBuffer name, String genre, Song[] songs) {
    this.name = name;
    this.genre = string_to_genre(genre);
    this.songs = songs;
  }

  void changeName(StringBuffer newName) {
    this.name = newName;
  }

  // using the replace function
  void replaceFirstName(StringBuffer newFirstName) {
    int whiteIndex;
    for (int i = 0 ; i < newFirstName.length() ; i++) {
      if (newFirstName.charAt(i) == ' ') {
        whiteIndex = i;
        break;
      }
    }
    this.name.replace(0, whiteIndex, newFirstName);
  }

  void changeGenre(String newGenre) {
    this.genre = string_to_genre(newGenre);
  }

  void changeSongs(Song[] songs) {
    this.songs = songs;
  }

  void display() {
    System.out.println("\nName of the Artist: " + this.name + "\nGenre of the Artist: " + genre_to_string(genre));
    System.out.println("Songs:");
    for (Song song : songs) {
      song.display();
    }
  }
}

// class #2
class Song {
  String songName;
  int durationInSeconds;

  Song(String name, int duration) {
    songName = name;
    durationInSeconds = duration;
  }

  void display() {
    System.out.println("\nSong Name: " + this.songName + "\nDuration: " + this.durationInSeconds + " seconds");
  }

  void play() {
    System.out.println("\nNow playing...\nSong: " + this.songName);
  }
}

// class #3
class ArtistManager {
  public static void main(String[] args) {
    Artist[] artists = new Artist[5];
    artists[0] = new Artist(new StringBuffer("Arden Diago"), "Pop", new Song[] {
        new Song("Random", 230),
        new Song("Hello World", 210)
    });

    artists[1] = new Artist(new StringBuffer("Kartik Dewnani"), "Rock", new Song[] {
        new Song("Saiyaara", 354),
        new Song("Why why why?", 165)
    });

    artists[2] = new Artist(new StringBuffer("Shumbham Swaraj"), "Electronic", new Song[] {
        new Song("One More ", 320),
        new Song("Get Lucky", 248)
    });

    artists[3] = new Artist(new StringBuffer("Manasa"), "Jazz", new Song[] {
        new Song("So What", 545),
        new Song("Freddie Freeloader", 580)
    });

    artists[4] = new Artist(new StringBuffer("Darshan Heble"), "Dance", new Song[] {
        new Song("Summer", 230),
        new Song("Feel So Close", 240)
    });
    artists[2].display();

    String nameOfFive = artists[4].name;
    System.out.println("\nThe name of the fifth artist is " + nameOfFive);
    artists[4].replaceFirstName("Darshana");

    Artist.Genre genreOfSecond = artists[0].genre;
    System.out.println("\nThe genre of the second artist is " + Artist.genre_to_string(genreOfSecond));

    System.out.println("---------");
    for (Artist guy : artists) {
      guy.display();
      System.out.println("---------");
    }
  }
}
