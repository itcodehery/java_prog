// Generics
public class MainClass {
    public static <T> void printArray(T[] array) {
        for (T element: array) {
           System.out.print(element + " "); 
        }
    }

    public static void main(String[] args) {
        Integer[] intarray = {1,2,3,4,5};
        String[] strarray = {"Java","Python","C++"};
        Character[] chararray = {'n','v','i','m'};

        printArray(intarray);
        System.out.println();
        printArray(strarray);
        System.out.println();
        printArray(chararray);
    }
}
