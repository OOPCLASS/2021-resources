package ro.utcluj;

public class House extends Property {

  private Double gardenSurface;

  public House(Double price, String city, Double surface, Double gardenSurface) {
    super(price, city, surface);
    this.gardenSurface = gardenSurface;
  }

  public Double getGardenSurface() {
    return gardenSurface;
  }

  public void setGardenSurface(Double gardenSurface) {
    this.gardenSurface = gardenSurface;
  }

  @Override
  String getDescription() {
    return String.format("HOUSE - %s sqm. - %s - %s sqm.", getSurface(), getPrice(), getGardenSurface() );
  }
}
