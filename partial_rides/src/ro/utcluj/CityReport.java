package ro.utcluj;

public class CityReport {


  private String city;
  private int vehicleIndex = 0;
  private int numberOfTaxis = 0;
  private int numberOfUber = 0;
  private int numberOfBolt = 0;
  private int numberOfFreeNow = 0;
  private Vehicle[] vehicles = new Vehicle[RidesService.VEHICLE_SIZE];

  public CityReport(String city) {
    this.city = city;
  }

  public void addVehicle(Vehicle vehicle) {
    switch (vehicle.getType()) {
      case BOLT -> numberOfBolt++;
      case UBER -> numberOfUber++;
      case FREE_NOW -> numberOfFreeNow++;
      case TAXI -> numberOfTaxis++;
    }
    vehicles[vehicleIndex++] = vehicle;
  }

  public String getCity() {
    return city;
  }

  public void printReport() {
    System.out.printf("%s: %s\n", city, getStats());
    for (int i = 0; i < vehicles.length; i++) {
      Vehicle vehicle = vehicles[i];
      if (vehicle != null) {
        System.out.println((i + 1) + ". " + vehicle.getDescription());
      }
    }
  }

  private String getStats() {
    int index = 0;
    String[] stats = new String[4];
    if (numberOfTaxis != 0) {
      stats[index++] = String.format("%d TAXI", numberOfTaxis);
    }
    if (numberOfUber != 0) {
      stats[index++] = String.format("%d UBER", numberOfUber);
    }
    if (numberOfBolt != 0) {
      stats[index++] = String.format("%d BOLT", numberOfBolt);
    }
    if (numberOfFreeNow != 0) {
      stats[index] = String.format("%d FREE_NOW", numberOfFreeNow);
    }

    String result = "";
    for (int i = 0; i < 4; i++) {
      String current = stats[i];
      if (current != null) {
        if (!result.equals("")) {
          result += ", ";
        }
        result += current;
      }
    }
    return result;
  }
}
