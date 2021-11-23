package ro.utcluj;

public class Taxi extends Vehicle {

  private String registrationNumber;
  private Double pricePerKm;

  public Taxi(String licensePlateNumber, boolean free, String city, String registrationNumber, Double pricePerKm) {
    super(licensePlateNumber, free, city, VehicleType.TAXI);
    this.registrationNumber = registrationNumber;
    this.pricePerKm = pricePerKm;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public Double getPricePerKm() {
    return pricePerKm;
  }

  public void setPricePerKm(Double pricePerKm) {
    this.pricePerKm = pricePerKm;
  }

  @Override
  public String getAdditionalInfo() {
    return String.valueOf(pricePerKm);
  }
}
