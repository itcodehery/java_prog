class StringDemo2 {
  public static void main(String[] args) {
    StringBuffer buf = new StringBuffer("What's uppp??? ");
    buf.append("Yooooo");
    buf.insert(7, "the way ");
    buf.replace(0, 5, "This");
    System.out.println(buf);
    buf.delete(5, 10);
    System.out.println(buf);
    buf.reverse();
    System.out.println(buf);
    // String bufOb2 = "This is not the way";
  }
}
