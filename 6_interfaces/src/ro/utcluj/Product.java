package ro.utcluj;

public abstract class Product {

  public abstract String getDescription();

  public void describeYourself() {
    System.out.println("Hello. I am a " + getDescription());
  }
}
