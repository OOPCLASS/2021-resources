package ro.utcluj;

import java.time.LocalDate;

public interface Deliverable {

  LocalDate getDeliveryDate();

  String getDescription();
}
