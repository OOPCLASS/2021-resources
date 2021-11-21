package ro.utcluj;

import java.time.LocalDate;

public class Box extends Package {

  private Double volume;

  public Box(LocalDate deliveryDate, String destination, Double weight, Double volume) {
    super(deliveryDate, destination, weight);
    this.volume = volume;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  @Override
  public String getDescription() {
    return String.format("%s - BOX - volume %s m^3", getAwb(), getVolume());
  }
}
