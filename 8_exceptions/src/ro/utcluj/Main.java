package ro.utcluj;

import ro.utcluj.StudentNotFoundException.ThirdPartySystem;

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
      String studentInfo = getStudentInfoById(123L);
      // studentInfo - DB
    } catch (StudentNotFoundException e) {
      e.getThirdPartySystem();
    }
    // student - cn - 0
    // Missing univInfo
  }

  private static String getStudentInfoById(long studentId) {
//    String univInfo = universityService.findStudentInfoById(studentId);
//    String townHallInfo = townHallService.findStudentInfoById(studentId);
//    String libraryInfo = libraryService.findStudentInfoById(studentId);

    throw new StudentNotFoundException("Nu am gasit studentul", ThirdPartySystem.LIBRARY);
//    return univInfo + " " + townHallInfo + " " + libraryInfo;
//    return null;
  }

  private static int getInteger(int size) {
    if (size > 10) {
      throw new NullPointerException();
    }
    return 10;
  }

  private static String getString() {
    return firstMethod();
  }

  private static String firstMethod() {
    return secondMethod();
  }

  private static String secondMethod() {
    if (getSecondString().equals("123")) {
      return "1234";
    }
    return null;
  }

  private static Object getSecondString() {
    return null;
  }
}
