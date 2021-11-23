package ro.utcluj;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Create the following classes:
 * --------------------
 * PrintingService
 * --------------------
 * - inkAmount: Double
 * - paperAmount: Integer
 * --------------------
 * + print(document: Document)
 * --------------------
 *
 * --------------------
 * Document
 * --------------------
 * - text: String
 * - numberOfPages: Integer
 * --------------------
 * --------------------
 *
 * Create 2 exceptions: OutOfInkException (unchecked) and OutOfPaperException (checked)
 * - print method consumes 0.001 * document.text.length * numberOfPages ink for each
 * document that's being printed
 * - print method consumes numberOfPages for each document that's being printed
 * - throw one of the exceptions depending on the situation
 */
public class Main {

  public static void main(String[] args) {
    try {
      String userInfo = getUserInfo("my-student-id");
    } catch (StudentNotFoundException e) {

    }
    // UTCN 1234
    // I couldn;t find
  }

  private static String getUserInfo(String studentId) {
    throw new StudentNotFoundException();
//    String facultyName = universityService.getFacultyNameByStudentId(studentId);
//    String regNo = officeService.getRegNoByStudentId(studentId);
//    return facultyName + " " + regNo;
//    return "123";
  }


}
