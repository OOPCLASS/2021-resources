package ro.utcluj;

public class Main {

  public static void main(String[] args) {
    Restaurant firstRestaurant = new Restaurant("London", new Coordinate(10.0, 10.0), "london-menu");
    Restaurant secondRestaurant = new Restaurant("Paris", new Coordinate(12.0, 12.0), "paris-menu");
    Restaurant thirdRestaurant = new Restaurant("Tokio", new Coordinate(20.0, 20.0), "tokyo-menu");

    Cinema firstCinema = new Cinema("Arta", new Coordinate(11.0, 10.0), new String[]{"Dune", "Spider-Man"});
    Cinema secondCinema = new Cinema("Victoria", new Coordinate(5.0, 5.0), new String[]{"Army of Thieves"});

    MapsService mapsService = new MapsService();
    mapsService.register(firstRestaurant);
    mapsService.register(secondRestaurant);
    mapsService.register(thirdRestaurant);
    mapsService.register(firstCinema);
    mapsService.register(secondCinema);

    mapsService.remove(new PointOfInterest[]{secondCinema});

    mapsService.printAll();

    PointOfInterest[] restaurants = mapsService.findAllByType(PointOfInterestType.RESTAURANT);

    System.out.println("Only restaurants: ");
    for (PointOfInterest restaurant : restaurants) {
      if (restaurant != null) {
        System.out.println(restaurant);
      }
    }

    System.out.println("In area 8, 14 and 14, 8: ");
    PointOfInterest[] inArea = mapsService.findAllInArea(new Coordinate(8.0, 14.0), new Coordinate(14.0, 8.0));
    for (PointOfInterest poi : inArea) {
      if (poi != null) {
        System.out.println(poi);
      }
    }
  }
}
