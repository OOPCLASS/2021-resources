package ro.utcluj;

public abstract class Vehicle {

  private String licensePlateNumber;
  private boolean free;
  private String city;
  private VehicleType type;

  public Vehicle(String licensePlateNumber, boolean free, String city, VehicleType type) {
    this.licensePlateNumber = licensePlateNumber;
    this.free = free;
    this.city = city;
    this.type = type;
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public void setLicensePlateNumber(String licensePlateNumber) {
    this.licensePlateNumber = licensePlateNumber;
  }

  public boolean isFree() {
    return free;
  }

  public void setFree(boolean free) {
    this.free = free;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public VehicleType getType() {
    return type;
  }

  public void setType(VehicleType type) {
    this.type = type;
  }

  public String getDescription() {
    return String.format("%s - %s - %s - %s", type, licensePlateNumber, getAdditionalInfo(), isFreeHumanReadable());
  }

  private String isFreeHumanReadable() {
    return free ? "liber": "ocupat";
  }

  public abstract String getAdditionalInfo();
}
