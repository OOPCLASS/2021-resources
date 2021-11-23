package ro.utcluj;

public class Main {

  public static void main(String[] args) {
    Taxi firstTaxi = new Taxi("taxi-1", true, "Cluj-Napoca", "reg1", 1.23);
    Taxi secondTaxi = new Taxi("taxi-2", true, "Bucuresti", "reg2", 2.23);
    Taxi thirdTaxi = new Taxi("taxi-3", true, "Craiova", "reg3", 3.23);

    ThirdPartyVehicle bolt = new ThirdPartyVehicle("bolt", true, "Cluj-Napoca", VehicleType.BOLT, "Alex");
    ThirdPartyVehicle uber = new ThirdPartyVehicle("uber", true, "Bucuresti", VehicleType.UBER, "Mircea");
    ThirdPartyVehicle freeNow = new ThirdPartyVehicle("free-now", true, "Craiova", VehicleType.FREE_NOW, "Mirel");

    RidesService ridesService = new RidesService();
    ridesService.register(firstTaxi);
    ridesService.register(secondTaxi);
    ridesService.register(thirdTaxi);
    ridesService.register(bolt);
    ridesService.register(uber);
    ridesService.register(freeNow);

    ridesService.remove(new Vehicle[]{freeNow});

    ridesService.printReport();
  }
}
