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

  public Student(String firstName, String lastName, String uniqueIdentificationNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.uniqueIdentificationNumber = uniqueIdentificationNumber;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
