package ro.utcluj.model;

public class Student {

  private String firstName;

  public void sayHello() {
    System.out.println(composeMessage(firstName));
  }

  private String composeMessage(String name) {
    return "My name is " + name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
