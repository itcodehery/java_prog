// Base class
class StudioEquipment {
    protected String name;
    protected double price;

    public StudioEquipment(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Equipment: " + name);
        System.out.println("Price: Rs. " + price);
    }

    public final void showWarranty() {
        System.out.println("All equipment has a 1-year warranty.");
    }
}

// Subclass 1
class Instrument extends StudioEquipment {
    private String instrumentType;

    public Instrument(String name, double price, String instrumentType) {
        super(name, price); // Call superclass constructor
        this.instrumentType = instrumentType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call superclass method
        System.out.println("Instrument Type: " + instrumentType);
    }
}

// Main class to demonstrate the features
public class MusicStudio {
    public static final String STUDIO_NAME = "Christ Uni Music Studio";

    public static void main(String[] args) {
        System.out.println("Welcome to " + STUDIO_NAME);

        Instrument guitar = new Instrument("Fender Stratocaster", 5600.00, "Electric Guitar");

        System.out.println("\n--- Instrument Details ---");
        guitar.displayDetails();
        guitar.showWarranty();
    }
}
