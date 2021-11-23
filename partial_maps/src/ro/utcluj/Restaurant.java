package ro.utcluj;

public class Restaurant extends PointOfInterest {

  private String menu;

  public Restaurant(String name, Coordinate coordinate, String menu) {
    super(name, PointOfInterestType.RESTAURANT, coordinate);
    this.menu = menu;
  }

  public String getMenu() {
    return menu;
  }

  public void setMenu(String menu) {
    this.menu = menu;
  }

  public String getAdditionalInfo() {
    return "menu='" + menu + "'";
  }
}
