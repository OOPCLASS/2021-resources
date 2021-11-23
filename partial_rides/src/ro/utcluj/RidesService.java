package ro.utcluj;

public class RidesService implements ReportService {

  public static final int VEHICLE_SIZE = 100;
  private Vehicle[] vehicles = new Vehicle[VEHICLE_SIZE];
  private int vehiclesIndex = 0;

  public String register(Vehicle vehicle) {
    if (vehicle.getLicensePlateNumber() == null ||
        vehicle.getCity() == null ||
        vehicle.getType() == null
    ) {
      return "Invalid data";
    }
    if (vehiclesIndex == VEHICLE_SIZE) {
      return "No more registrations allowed";
    }
    vehicles[vehiclesIndex++] = vehicle;
    return "Vehicle successfully registered";
  }

  public Vehicle[] findAllByCityAndTypeIn(String city, VehicleType[] types) {
    int index = 0;
    Vehicle[] foundVehicles = new Vehicle[VEHICLE_SIZE];
    for (Vehicle vehicle : vehicles) {
      if (vehicle.getCity().equals(city)) {
        for (VehicleType type : types) {
          if (vehicle.getType().equals(type)) {
            foundVehicles[index++] = vehicle;
            break;
          }
        }
      }
    }
    return foundVehicles;
  }

  public Vehicle[] remove(Vehicle[] vehiclesToBeRemoved) {
    int index = 0;
    Vehicle[] notRemovedVehicles = new Vehicle[vehiclesToBeRemoved.length];
    for (Vehicle vehicleToBeRemoved : vehiclesToBeRemoved) {
      boolean removed = false;
      for (int i = 0; i < vehicles.length; i++) {
        Vehicle vehicle = vehicles[i];
        if (vehicle != null) {
          if (vehicleToBeRemoved != null) {
            if (vehicleToBeRemoved.getLicensePlateNumber().equals(vehicle.getLicensePlateNumber()) &&
                vehicle.isFree()) {
              removed = true;
              shiftLeftVehicles(i);
              vehicles[vehiclesIndex - 1] = null;
              vehiclesIndex--;
            }
          }
        }
      }
      if (!removed) {
        notRemovedVehicles[index++] = vehicleToBeRemoved;
      }
    }
    return notRemovedVehicles;
  }

  public Double calculatePrice(Vehicle vehicle, Double distanceInKm) {
    if (VehicleType.TAXI.equals(vehicle.getType())) {
      return ((Taxi) vehicle).getPricePerKm() * distanceInKm;
    }
    return 2.34 * distanceInKm;
  }

  @Override
  public void printReport() {
    CityReport[] report = toReport();
    for (CityReport cityReport : report) {
      if (cityReport != null) {
        cityReport.printReport();
      }
    }
  }

  private CityReport[] toReport() {
    int index = 0;
    CityReport[] reports = new CityReport[vehiclesIndex];
    String[] cities = getCities();
    for (String city : cities) {
      if (city != null) {
        CityReport cityReport = new CityReport(city);
        for (Vehicle vehicle : vehicles) {
          if (vehicle != null) {
            if (vehicle.getCity().equals(city)) {
              cityReport.addVehicle(vehicle);
            }
          }
        }
        reports[index++] = cityReport;
      }
    }
    return reports;
  }

  private String[] getCities() {
    int index = 0;
    String[] cities = new String[vehiclesIndex];
    for (Vehicle vehicle : vehicles) {
      if (vehicle != null) {
        boolean found = false;
        for (int i = 0; i < index; i++) {
          if (cities[i].equals(vehicle.getCity())) {
            found = true;
            break;
          }
        }
        if (!found) {
          cities[index++] = vehicle.getCity();
        }
      }
    }
    return cities;
  }

  private void shiftLeftVehicles(int index) {
    for (int i = index; i < vehiclesIndex - 1; i++) {
      vehicles[i] = vehicles[i + 1];
    }
  }
}
