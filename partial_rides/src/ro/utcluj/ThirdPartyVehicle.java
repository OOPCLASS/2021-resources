package ro.utcluj;

public class ThirdPartyVehicle extends Vehicle {

  private String driverName;

  public ThirdPartyVehicle(String licensePlateNumber, boolean free, String city, VehicleType type, String driverName) {
    super(licensePlateNumber, free, city, type);
    this.driverName = driverName;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  @Override
  public String getAdditionalInfo() {
    return driverName;
  }
}
