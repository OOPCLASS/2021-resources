package ro.utcluj.validator;

import java.util.Objects;
import ro.utcluj.exception.ValidationFailedException;
import ro.utcluj.model.User;

// parametrized tests
// https://www.baeldung.com/parameterized-tests-junit-5
public class UserValidator {

  public boolean validate(User user) {
    if (Objects.isNull(user)) {
      throw new ValidationFailedException("User object cannot be null");
    }
    return true;
  }
}
