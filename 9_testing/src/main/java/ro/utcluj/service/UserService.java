package ro.utcluj.service;

import java.util.HashMap;
import java.util.Map;
import ro.utcluj.model.User;
import ro.utcluj.validator.UserValidator;

public class UserService {

  private Map<Long, User> users = new HashMap<>();
  private UserValidator validator = new UserValidator();
  private Long index = 0L;

  public void save(User user) {
    if (validator.validate(user)) {
      users.put(index++, user);
    }
  }
}
