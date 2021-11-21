package ro.utcluj;

import java.time.LocalDate;

public class Envelope extends Package {

  private EnvelopeSize envelopeSize;

  public Envelope(LocalDate deliveryDate, String destination, Double weight, EnvelopeSize envelopeSize) {
    super(deliveryDate, destination, weight);
    this.envelopeSize = envelopeSize;
  }

  public EnvelopeSize getEnvelopeSize() {
    return envelopeSize;
  }

  public void setEnvelopeSize(EnvelopeSize envelopeSize) {
    this.envelopeSize = envelopeSize;
  }

  @Override
  public String getDescription() {
    return String.format("%s - ENVELOPE - size %s", getAwb(), getEnvelopeSize());
  }
}
