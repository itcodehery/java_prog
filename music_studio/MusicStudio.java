class Artist {
  public String name;
  public String username;
  private String password;
  private double earnings;

  String getPassword() {
    return this.password;
  }

  double getEarnings() {
    return this.earnings;
  }

  void setPassword(String password) {
    this.password = password;
  }

  void setEarnings(double earnings) {
    this.earnings = earnings;
  }

  public Artist(String name, String username, String password, double earnings) {
    this.name = name;
    this.username = username;
    setPassword(password);
    setEarnings(earnings);
  }
}

class MusicStudio {

  public static void main(String[] args) {
    Artist art1 = new Artist("Arden", "arden.diago", "abc123", 43.5);
    System.out.println(art1.name);
    System.out.println(art1.username);
    System.out.println(art1.getPassword());
    System.out.println(art1.getEarnings());
  }
}
