package ro.utcluj;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import ro.utcluj.model.Student;

/**
 * Create a StudentRegistry which holds an array of Student(s). Initialize the array
 * with at least 10 instances (random values for the attributes). Every student
 * could have one or more Course(s) which he/she attends. For each Course we should
 * store the name, creditsNumber and an array of roomNumbers
 *
 * 1. Try to read student info from a file students.txt
 * 2. Try to read courses info from a file courses.txt
 * 3. Add a method in StudentRegistry which adds a Student to the array inside StudentRegistry
 */
public class Main {

  public static void main(String[] args) throws IOException {
    int[] numbers = new int[10];
    Student[] students = new Student[10];
    Student firstStudent = new Student("Alex", "Bondor", "123");
    students[0] = firstStudent;
    System.out.println(firstStudent.firstName);

    Student secondStudent = new Student();
    secondStudent.uniqueIdentificationNumber = "234";
    secondStudent.firstName = "Mircea";
    secondStudent.lastName = "Muntean";

    System.out.println(firstStudent.getFullName());
    System.out.println(secondStudent.getFullName());

    Path fileName = Path.of("resources/student-register.txt");
    List<String> fileContent = Files.readAllLines(fileName);

    for (String line : fileContent) {
      String[] lineWords = line.split(" ");
      String firstName = lineWords[0];
      String lastName = lineWords[1];
    }
  }
}
