import java.util.ArrayList;

interface CourseMaterial {
  void uploadMaterial(String material);

  void viewMaterial();
}

interface LiveSession {
  void startSession();

  void endSession();
}

class OnlineClass implements CourseMaterial, LiveSession {
  String className;
  ArrayList<String> material;

  OnlineClass(String name, String initialMaterial) {
    this.className = name;
    this.material = new ArrayList<String>();
    this.material.addFirst(initialMaterial);
  }

  public void uploadMaterial(String material) {
    this.material.add(material);
    System.out.println("Material: " + material + " added to the class.");
  }

  public void viewMaterial() {
    System.out.println("-------------------\nShowing Material:\n------------------");
    for (String i : material) {
      System.out.println(i);
    }
    System.out.println("-------------------");
  }

  public void startSession() {
    System.out.println(this.className + " class session started.");
  }

  public void endSession() {
    System.out.println(this.className + " class session ended.");
  }
}

public class OnlineLearner {
  public static void main(String[] args) {
    OnlineClass var1 = new OnlineClass("ADT", "Unit 1 PPT");

    var1.viewMaterial();
    var1.uploadMaterial("Unit 2 PPT");
    var1.startSession();
    var1.endSession();
    var1.viewMaterial();
  }
}
