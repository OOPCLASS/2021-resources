package ro.utcluj;

public class Main {

  public static void main(String[] args) {
    PropertyService propertyService = new PropertyService();

    House firstHouse = new House(100000.0, "Cluj-Napoca", 80.0, 15.0);
    House secondHouse = new House(120000.0, "Cluj-Napoca", 100.0, 35.0);
    House thirdHouse = new House(90000.0, "Cluj-Napoca", 85.0, 50.0);
    Apartment firstApartment = new Apartment(85000.0, "Cluj-Napoca", 75.0, 2);
    Apartment secondApartment = new Apartment(90000.0, "Cluj-Napoca", 60.0, 3);
    Apartment thirdApartment = new Apartment(140000.0, "Cluj-Napoca", 123.0, 5);

    propertyService.register(new House(100000.0, "Turda", 80.0, 15.0));
    propertyService.register(new House(120000.0, "Turda", 100.0, 35.0));
    propertyService.register(new House(90000.0, "Turda", 85.0, 50.0));
    propertyService.register(new Apartment(85000.0, "Dej", 75.0, 2));
    propertyService.register(new Apartment(90000.0, "Dej", 60.0, 3));
    propertyService.register(new Apartment(140000.0, "Dej", 123.0, 5));

    propertyService.register(firstHouse);
    propertyService.register(secondHouse);
    propertyService.register(thirdHouse);
    propertyService.register(firstApartment);
    propertyService.register(secondApartment);
    propertyService.register(thirdApartment);

    Property[] propertiesToRemove = new Property[1];
    propertiesToRemove[0] = secondApartment;
    propertyService.remove(propertiesToRemove);

    propertyService.printReport();

    System.out.println("All between 1000 & 1100 price/sqm");
    Property[] allByPricePerSqmBetween = propertyService.findAllByPricePerSqmBetween(1000.0, 1100.0);
    for (Property property : allByPricePerSqmBetween) {
      if (property != null) {
        System.out.println(property.getDescription());
      }
    }
  }
}
