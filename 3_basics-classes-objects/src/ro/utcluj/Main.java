package ro.utcluj;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

  public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Path fileName = Path.of("resources/student-register.json");
    String content = Files.readString(fileName);
    StudentRegister studentRegister = objectMapper.readValue(content, StudentRegister.class);
  }
}
