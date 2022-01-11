package ro.utcluj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
      String userName = getUserName(100);
    } catch (StudentNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String getUserName(int studentId) throws IOException {
    if (studentId > 10) {
      throw new StudentNotFoundException("123");
    } else if (studentId > 20) {
      throw new IOException("altceva");
    }
    return "Alex";
  }

  private static Double getFirst() {
    return getSecond();
  }

  private static Double getSecond() {
    return getThird();
  }

  private static Double getThird() {
    return Double.valueOf("12dsf");
  }

  private static String getName() {
    return null;
  }
}
