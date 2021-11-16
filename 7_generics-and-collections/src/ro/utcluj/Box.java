package ro.utcluj;

import java.util.List;

public class Box<T extends Person> {

  private T content;

  public Box(Box<?> content) {
//    this.content = content;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }
}
