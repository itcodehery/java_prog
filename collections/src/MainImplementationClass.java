import java.util.*;

class ArrayListClass {

    private List<String> classList;

    public void addToList(String something) {
        classList.add(something);
    }

    public void clearList() {
        classList = new ArrayList<String>();
    }

    public void displayList() {
        for (String i : classList) {
            System.out.println("- " + i);
        }
    }

    public void insertAt(int position, String something) {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
            return;
        }
        classList.add(position, something);
    }

    public void addList(List<String> array) {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
            return;
        }
        classList.addAll(array);
    }

    public boolean doesItHave(String thisElement) {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
            return false;
        }
        return classList.contains(thisElement);
    }

    public boolean doesItHaveAllOfThese(List<String> theseElements) {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
            return false;
        }
        return classList.containsAll(theseElements);
    }

    public String getFirst() {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
            return "";
        }
        return classList.getFirst();
    }

    public boolean isItTheSameAs(List<String> collection) {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
            return false;
        }
        return classList.equals(collection);
    }

    public void removeThis(String something) {
        if (classList.remove(something)) {
            System.out.println("Removed successfully");
        } else {
            System.out.println("Element doesn't exist!");
        }
    }

    public int getLength() {
        if (classList.size() < 1) {
            System.out.println("List is empty!");
        }
        return classList.size();
    }

    public ArrayListClass() {
        super();
        classList = new ArrayList<String>();
    }
}

class LinkedListClass {

    private LinkedList<Integer> marksList;

    public void addToLL(Integer something) {
        marksList.add(something);
    }

    public void clearLL() {
        marksList = new LinkedList<>();
    }

    public void displayLL() {
        for (Integer i : marksList) {
            System.out.println("- " + i);
        }
    }
}

// Set

public class MainImplementationClass {

    public static void main(String[] args) {
        // ArrayList
        var newList = new ArrayListClass();
        newList.addToList("Arden");
        newList.addToList("Arjit");
        newList.addToList("Arnav");
        if (newList.doesItHave("Arden")) {
            System.out.println("Arden is in the list!");
        }

        newList.displayList();
        System.out.println("Length of newList: " + newList.getLength());
        System.out.println("First element of newList: " + newList.getFirst());

        var anotherList = new ArrayList<String>();
        anotherList.add("Arden");
        anotherList.add("Arjit");
        anotherList.add("Arnav");

        System.out.println("\nAnother List: ");
        for (String s : anotherList) {
            System.out.println(s);
        }

        if (newList.isItTheSameAs(anotherList)) {
            System.out.println("Yes, it is the same as Another List!");
        } else {
            System.out.println("No, it is not the same as another list!");
        }

        newList.addList(anotherList);
        System.out.println("Printing newList which is old now...");
        newList.displayList();
    }
}
