package ro.utcluj.model;

/**
 *
 */
public class Student {

  public String uniqueIdentificationNumber = ""; // 8 bytes
  public String firstName = "";
  public String lastName = "";
  public int[] grades;

  public Student() {
    System.out.println("hello");
  }

  public Student(String a, String b, String c) {
    this.firstName = a;
    this.lastName = b;
    this.uniqueIdentificationNumber = c;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
