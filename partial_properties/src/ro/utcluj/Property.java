package ro.utcluj;

public abstract class Property {

  private Long identificationNumber;
  private Double price;
  private String city;
  private Double surface;

  public Property(Double price, String city, Double surface) {
    this.price = price;
    this.city = city;
    this.surface = surface;
  }

  public Long getIdentificationNumber() {
    return identificationNumber;
  }

  public void setIdentificationNumber(Long identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Double getSurface() {
    return surface;
  }

  public void setSurface(Double surface) {
    this.surface = surface;
  }

  abstract String getDescription();
}
