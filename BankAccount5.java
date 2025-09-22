class BankAccount {
  private String AccountPassword = "abc";
  public String Name = "Ganesh";

  private void display1() {
    System.out.println(AccountPassword);
  }

  void display2() {
    System.out.println(Name);
  }

  void showPassword() {
    display1();
  }
}

class BankAccount5 {
  public static void main(String[] args) {
    BankAccount acc1 = new BankAccount();
    acc1.display2();
    acc1.showPassword();
  }
}
