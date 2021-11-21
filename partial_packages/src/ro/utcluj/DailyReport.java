package ro.utcluj;

import java.time.LocalDate;

public class DailyReport {

  private LocalDate date;
  private int deliverablesIndex = 0;
  private Deliverable[] deliverables;

  public DailyReport(LocalDate date, int size) {
    this.date = date;
    this.deliverables = new Deliverable[size];
  }

  public LocalDate getDate() {
    return date;
  }

  public void addPackage(Package aPackage) {
    deliverables[deliverablesIndex++] = aPackage;
  }

  public void printReport(int index) {
    System.out.printf("%d. %s - %d packages\n", index, date, deliverablesIndex);
    for (Deliverable deliverable : deliverables) {
      if (deliverable != null) {
        System.out.println(deliverable.getDescription());
      }
    }
  }
}
