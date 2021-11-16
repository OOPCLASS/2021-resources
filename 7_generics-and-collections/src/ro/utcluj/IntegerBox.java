package ro.utcluj;

import java.util.Objects;

public class IntegerBox {

  private Integer content;
  private String attribute;

  public IntegerBox(Integer content) {
    this.content = content;
  }

  public Integer getContent() {
    return content;
  }

  public void setContent(Integer content) {
    this.content = content;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, attribute);
  }
}

