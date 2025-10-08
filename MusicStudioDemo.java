class Artist {
    protected String name;
    protected String genre;
    
    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void perform() {
        System.out.println(name + " is performing a generic " + genre + " piece");
    }
    
    public void recordSong() {
        System.out.println(name + " is recording a song in the studio");
    }
    
    public void getArtistInfo() {
        System.out.println("Artist: " + name + ", Genre: " + genre);
    }
}

class Singer extends Artist {
    private String vocalRange;
    
    public Singer(String name, String vocalRange) {
        super(name, "Vocal");
        this.vocalRange = vocalRange;
    }
    
    @Override
    public void perform() {
        System.out.println(name + " is singing with " + vocalRange + " vocal range");
    }
    
    @Override
    public void recordSong() {
        System.out.println(name + " is recording vocals in the sound booth with headphones");
    }
    
    @Override
    public void getArtistInfo() {
        System.out.println("Singer: " + name + ", Vocal Range: " + vocalRange);
    }
}

class Instrumentalist extends Artist {
    private String instrument;
    
    public Instrumentalist(String name, String instrument, String genre) {
        super(name, genre);
        this.instrument = instrument;
    }
    
    @Override
    public void perform() {
        System.out.println(name + " is playing the " + instrument + " in " + genre + " style");
    }
    
    @Override
    public void recordSong() {
        System.out.println(name + " is recording " + instrument + " tracks with professional audio equipment");
    }
    
    @Override
    public void getArtistInfo() {
        System.out.println("Instrumentalist: " + name + ", Instrument: " + instrument + ", Genre: " + genre);
    }
}

public class MusicStudioDemo {
    public static void main(String[] args) {
        System.out.println("=== Music Studio Artist Management - Method Overriding Demo ===\n");
        
        Artist genericArtist = new Artist("Alex Johnson", "Contemporary");
        Artist vocalist = new Singer("Sarah Williams", "Soprano");
        Artist guitarist = new Instrumentalist("Mike Chen", "Electric Guitar", "Rock");
        
        System.out.println("=== Generic Artist ===");
        genericArtist.getArtistInfo();
        genericArtist.perform();
        genericArtist.recordSong();
        
        System.out.println("\n=== Singer (Overridden Methods) ===");
        vocalist.getArtistInfo();
        vocalist.perform();
        vocalist.recordSong();
        
        System.out.println("\n=== Instrumentalist (Overridden Methods) ===");
        guitarist.getArtistInfo();
        guitarist.perform();
        guitarist.recordSong();
        
        System.out.println("\n=== Studio Session - Runtime Polymorphism ===");
        Artist[] studioSession = {
            new Artist("Demo Artist", "Pop"), 
            new Singer("Emma Davis", "Alto"), 
            new Instrumentalist("David Lee", "Piano", "Jazz")
        };
        
        System.out.println("Today's recording session lineup:");
        for (Artist artist : studioSession) {
            artist.perform();
        }
    }
}
