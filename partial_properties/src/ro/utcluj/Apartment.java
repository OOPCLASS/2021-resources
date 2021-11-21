package ro.utcluj;

public class Apartment extends Property {

  private int floor;

  public Apartment(Double price, String city, Double surface, int floor) {
    super(price, city, surface);
    this.floor = floor;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  @Override
  String getDescription() {
    return String.format("APARTMENT - %s sqm. - %s - %s sqm.", getSurface(), getPrice(), getFloor() );
  }
}
