package ro.utcluj.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.utcluj.exception.ValidationFailedException;
import ro.utcluj.model.User;

public class UserValidatorTest {

  private UserValidator validator = new UserValidator();

  @Test
  public void testUserIsNull() {
    ValidationFailedException exception =
        Assertions.assertThrows(ValidationFailedException.class, () -> validator.validate(null));
    Assertions.assertEquals("User object cannot be null", exception.getMessage());
  }

  @Test
  public void testUserNonNullReturnsTrue() {
    boolean result = validator.validate(new User());

    Assertions.assertTrue(result);
  }
}
