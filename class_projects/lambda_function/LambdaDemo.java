interface MathOperation {
    int operate(int a, int b);
}

public class LambdaDemo {
    public static void main(String[] args) {
        MathOperation add = (a,b) -> a + b;
        MathOperation multiply = (c,d) -> c * d;
        System.out.println("Sum: " + add.operate(1,2));
        System.out.println("Multiply: " + multiply.operate(3,2));
    }
}
