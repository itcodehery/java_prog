
class MusicStudio {
    // Method to book a single hour session
    public double bookSession(String artistName, int hours) {
        double rate = 100.0; // $100 per hour
        System.out.println("Booking " + hours + " hour session for " + artistName);
        return hours * rate;
    }
    
    // Overloaded method to book session with specific equipment
    public double bookSession(String artistName, int hours, String equipment) {
        double baseRate = 100.0;
        double equipmentFee = 50.0;
        System.out.println("Booking " + hours + " hour session for " + artistName + " with " + equipment);
        return (hours * baseRate) + equipmentFee;
    }
    
    // Overloaded method to book session with discount
    public double bookSession(String artistName, int hours, double discountPercent) {
        double rate = 100.0;
        double total = hours * rate;
        double discount = total * (discountPercent / 100);
        System.out.println("Booking " + hours + " hour session for " + artistName + " with " + discountPercent + "% discount");
        return total - discount;
    }
    
    // Overloaded method for premium package booking
    public double bookSession(String artistName, int hours, String equipment, boolean premiumPackage) {
        double baseRate = 100.0;
        double equipmentFee = 50.0;
        double premiumFee = premiumPackage ? 200.0 : 0.0;
        System.out.println("Booking " + hours + " hour session for " + artistName + " with " + equipment + 
                          (premiumPackage ? " (Premium Package)" : ""));
        return (hours * baseRate) + equipmentFee + premiumFee;
    }
}

public class StudioBookingDemo {
    public static void main(String[] args) {
        MusicStudio studio = new MusicStudio();
        
        // Calling different overloaded methods
        System.out.println("Cost: $" + studio.bookSession("John Doe", 3));
        System.out.println("Cost: $" + studio.bookSession("Jane Smith", 2, "Professional Microphones"));
        System.out.println("Cost: $" + studio.bookSession("Rock Band", 4, 15.0));
        System.out.println("Cost: $" + studio.bookSession("Pop Star", 5, "Full Recording Setup", true));
    }
}
