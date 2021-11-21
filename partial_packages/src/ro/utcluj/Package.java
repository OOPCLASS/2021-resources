package ro.utcluj;

import java.time.LocalDate;

public abstract class Package implements Deliverable {

  private String awb;
  private LocalDate deliveryDate;
  private String destination;
  private Double weight;

  public Package(LocalDate deliveryDate, String destination, Double weight) {
    this.deliveryDate = deliveryDate;
    this.destination = destination;
    this.weight = weight;
  }

  public String getAwb() {
    return awb;
  }

  public void setAwb(String awb) {
    this.awb = awb;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public abstract String getDescription();

  public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }
}
