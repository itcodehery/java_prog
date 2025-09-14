// Interface for items that can be stored in inventory
interface Storable {
    String getName();
    double getPrice();
    String getDescription();
}

// Generic interface for inventory operations
interface InventoryManager<T extends Storable> {
    void addItem(T item);
    T getItem(int index);
    int getItemCount();
    void displayInventory();
}

// Concrete classes implementing Storable
class Book implements Storable {
    private String title;
    private String author;
    private double price;
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    @Override
    public String getName() {
        return title;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getDescription() {
        return "Book: " + title + " by " + author;
    }
}

class Electronics implements Storable {
    private String model;
    private String brand;
    private double price;
    
    public Electronics(String model, String brand, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }
    
    @Override
    public String getName() {
        return model;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getDescription() {
        return "Electronics: " + brand + " " + model;
    }
}

// Generic class implementing the InventoryManager interface
class Inventory<T extends Storable> implements InventoryManager<T> {
    private java.util.List<T> items;
    
    public Inventory() {
        this.items = new java.util.ArrayList<>();
    }
    
    @Override
    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getDescription());
    }
    
    @Override
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }
    
    @Override
    public int getItemCount() {
        return items.size();
    }
    
    @Override
    public void displayInventory() {
        System.out.println("\n--- Inventory Contents ---");
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            System.out.println((i + 1) + ". " + item.getDescription() + 
                             " - $" + String.format("%.2f", item.getPrice()));
        }
        System.out.println("Total items: " + items.size());
    }
    
    // Additional method to calculate total value
    public double getTotalValue() {
        return items.stream().mapToDouble(Storable::getPrice).sum();
    }
}

// Main class to demonstrate the program
public class InventorySystem {
    public static void main(String[] args) {
        // Create inventories for different types of items
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Electronics> electronicsInventory = new Inventory<>();
        
        // Add some books
        System.out.println("=== Adding Books ===");
        bookInventory.addItem(new Book("The Java Programming Language", "James Gosling", 45.99));
        bookInventory.addItem(new Book("Effective Java", "Joshua Bloch", 52.99));
        bookInventory.addItem(new Book("Clean Code", "Robert Martin", 42.50));
        
        // Add some electronics
        System.out.println("\n=== Adding Electronics ===");
        electronicsInventory.addItem(new Electronics("iPhone 15", "Apple", 999.99));
        electronicsInventory.addItem(new Electronics("Galaxy S24", "Samsung", 899.99));
        electronicsInventory.addItem(new Electronics("MacBook Pro", "Apple", 1999.99));
        
        // Display inventories
        bookInventory.displayInventory();
        System.out.println("Total value: $" + String.format("%.2f", bookInventory.getTotalValue()));
        
        electronicsInventory.displayInventory();
        System.out.println("Total value: $" + String.format("%.2f", electronicsInventory.getTotalValue()));
        
        // Demonstrate getting specific items
        System.out.println("\n=== Item Retrieval Demo ===");
        Book firstBook = bookInventory.getItem(0);
        if (firstBook != null) {
            System.out.println("First book: " + firstBook.getDescription());
        }
        
        Electronics firstElectronic = electronicsInventory.getItem(0);
        if (firstElectronic != null) {
            System.out.println("First electronic: " + firstElectronic.getDescription());
        }
        
        // Demonstrate polymorphism with generic method
        System.out.println("\n=== Polymorphism Demo ===");
        printInventoryInfo(bookInventory);
        printInventoryInfo(electronicsInventory);
    }
    
    // Generic method that works with any inventory type
    public static <T extends Storable> void printInventoryInfo(InventoryManager<T> inventory) {
        System.out.println("Inventory contains " + inventory.getItemCount() + " items");
    }
}
