import java.util.List;

class GenericClass<T> {
   private List<T> storage;

    void showStorage() {
        for (T ele : storage) {
            System.out.print(ele + " ");
        }
    }

    GenericClass() {
        List<T> list = {};
        storage = list;
    }

    void addToStorage(T newElement) {
        storage.add(newElement);
    }
}

public class AnotherClass {
    public static void main(String[] args) {
    GenericClass<Integer> intStore = new GenericClass<Integer>();
    intStore.addToStorage(1);
    intStore.addToStorage(2);
    intStore.addToStorage(3);
    intStore.showStorage();
}
} 
