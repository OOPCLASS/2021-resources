package ro.utcluj.model;

public class Student implements Comparable, Identifiable {

  private String name;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Object object) {
    if (object instanceof Student) {
      Student student = (Student) object;
      return this.name.compareTo(student.getName());
    }
    return 0;
  }

  @Override
  public int getId() {
    return 0;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        '}';
  }
}
