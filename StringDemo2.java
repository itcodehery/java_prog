class StringDemo2 {
  public static void main(String[] args) {
    StringBuffer bufOb1 = new StringBuffer("What's uppp??? ");
    bufOb1.append("Yooooo");
    bufOb1.insert(7, "the way ");
    bufOb1.replace(0, 5, "This");
    System.out.println(bufOb1);
    bufOb1.delete(5, 10);
    System.out.println(bufOb1);
    bufOb1.reverse();
    System.out.println(bufOb1);
    // String bufOb2 = "This is not the way";
  }
}