package ro.utcluj;

public class PropertyReport {

  private String city;
  private int propertyIndex = 0;
  private int numberOfHouses = 0;
  private int numberOfApartments = 0;
  private Property[] properties = new Property[PropertyService.PROPERTIES_SIZE];

  public PropertyReport(String city) {
    this.city = city;
  }

  public void addProperty(Property property) {
    if (property instanceof House) {
      numberOfHouses++;
    }
    if (property instanceof Apartment) {
      numberOfApartments++;
    }
    properties[propertyIndex++] = property;
  }

  public String getCity() {
    return city;
  }

  public void printReport(int index) {
    System.out.printf("%d. %s - %s%n", index, city, getStats());
    for (Property property : properties) {
      if (property != null) {
        System.out.println(property.getDescription());
      }
    }
  }

  private String getStats() {
    if (numberOfHouses != 0 && numberOfApartments != 0) {
      return String.format("%d houses, %d apartments", numberOfHouses, numberOfApartments);
    } else if (numberOfHouses != 0) {
      return String.format("%d houses", numberOfHouses);
    } else {
      return String.format("%d apartments", numberOfApartments);
    }
  }
}
