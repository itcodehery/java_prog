class StringDemo {
  public static void main(String[] args) {
    String strOb1 = "First String";
    String strOb2 = "Second String";
    String strOb3 = strOb1 + " and " + strOb2;

    System.out.println(strOb3);
    System.out.println("Length of Ob1: " + strOb1.length());
    System.out.println("Char at index 3 in Ob2 is: " +  strOb2.charAt(2));
    System.out.println(strOb2);
    if (strOb1.equals(strOb2)) 
    System.out.println("They are equal!");
    else
    System.out.println("They are not equal!");
  }
}
