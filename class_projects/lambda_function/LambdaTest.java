public class LambdaTest {
  public static void main(String[] args) {
    int a = 10, b = 20;
    int sum = () -> a + (b ^ 2);
    System.out.println(sum);
  }
}
