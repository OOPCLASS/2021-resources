package ro.utcluj;

import java.time.LocalDate;

public class Main {

  public static void main(String[] args) {
    WarehouseService warehouseService = new WarehouseService();

    Box firstBox = new Box(LocalDate.of(2021, 11, 21), "Bucuresti", 10.0, 50.0);
    Box secondBox = new Box(LocalDate.of(2021, 11, 21), "Craiova", 22.0, 277.0);
    Box thirdBox = new Box(LocalDate.of(2021, 11, 21), "Pitesti", 11.0, 4.0);

    Envelope firstEnvelope = new Envelope(LocalDate.of(2021, 11, 21), "Bucuresti", 1.0, EnvelopeSize.S);
    Envelope secondEnvelope = new Envelope(LocalDate.of(2021, 11, 21), "Constanta", 0.80, EnvelopeSize.M);
    Envelope thirdEnvelope = new Envelope(LocalDate.of(2021, 12, 21), "Baia Mare", 2.0, EnvelopeSize.L);

    warehouseService.register(firstBox);
    warehouseService.register(secondBox);
    warehouseService.register(thirdBox);
    warehouseService.register(firstEnvelope);
    warehouseService.register(secondEnvelope);
    warehouseService.register(thirdEnvelope);

    Package[] packagesToRemove = new Package[1];
    packagesToRemove[0] = secondBox;
    warehouseService.remove(packagesToRemove);

    warehouseService.printReport();

    System.out.println("All for 21.11.2021");
    Deliverable[] allByDeliveryDate = warehouseService.findAllByDeliveryDate(LocalDate.of(2021, 11, 21));
    for (Deliverable deliverable : allByDeliveryDate) {
      if (deliverable != null) {
        System.out.println(deliverable.getDescription());
      }
    }
  }
}
