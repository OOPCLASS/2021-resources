package ro.utcluj;

import java.time.LocalDate;
import java.util.Arrays;

public class WarehouseService {

  private int resizeIndex = 1;
  private static final int PACKAGES_SIZE = 100;
  private Package[] packages = new Package[PACKAGES_SIZE];
  private int packagesIndex = 0;
  private Long awbIndex = 0L;

  public String register(Package packageToRegister) {
    if (packageToRegister.getAwb() != null) {
      return "AWB already assigned";
    }
    if (packageToRegister.getDestination() == null || packageToRegister.getDeliveryDate() == null) {
      return "Delivery date/Destination not set";
    }
    if (packagesIndex == getPackagesSize() - 1) {
      resizePackages();
    }
    return sortedRegister(packageToRegister);
  }

  public Deliverable[] findAllByDeliveryDate(LocalDate date) {
    int byDeliveryDateIndex = 0;
    Deliverable[] byDeliveryDate = new Deliverable[packages.length];
    for (Package aPackage : packages) {
      if (aPackage != null && aPackage.getDeliveryDate().equals(date)) {
        byDeliveryDate[byDeliveryDateIndex++] = aPackage;
      }
    }
    return byDeliveryDate;
  }

  public Package[] remove(Package[] packagesToBeRemoved) {
    int removedPackageIdsIndex = 0;
    Package[] notRemovedPackages = new Package[packagesToBeRemoved.length];
    for (Package packageToBeRemoved : packagesToBeRemoved) {
      boolean removed = false;
      if (packageToBeRemoved != null) {
        for (int j = 0; j < packagesIndex; j++) {
          Package currentPackage = packages[j];
          if (packageToBeRemoved.getAwb().equals(currentPackage.getAwb())) {
            removed = true;
            shiftLeftPackages(j);
            packages[packagesIndex - 1] = null;
            packagesIndex -= 1;
            break;
          }
        }
        if (!removed) {
          notRemovedPackages[removedPackageIdsIndex++] = packageToBeRemoved;
        }
      }
    }
    return notRemovedPackages;
  }

  public void printReport() {
    DailyReport[] report = toReport();
    for (int i = 0; i < report.length; i++) {
      if (report[i] != null) {
        report[i].printReport(i + 1);
      }
    }
  }

  private DailyReport[] toReport() {
    int reportsIndex = 0;
    DailyReport[] reports = new DailyReport[packagesIndex];
    for (Package aPackage : packages) {
      boolean packageAdded = false;
      for (int i = 0; i < reportsIndex && aPackage != null; i++) {
        DailyReport report = reports[i];
        if (report != null && report.getDate().equals(aPackage.getDeliveryDate())) {
          packageAdded = true;
          report.addPackage(aPackage);
        }
      }
      if (!packageAdded && aPackage != null) {
        DailyReport dailyReport = new DailyReport(aPackage.getDeliveryDate(), getPackagesSize());
        dailyReport.addPackage(aPackage);
        reports[reportsIndex++] = dailyReport;
      }
    }
    return reports;
  }

  private int getPackagesSize() {
    return PACKAGES_SIZE * resizeIndex;
  }

  private void resizePackages() {
    resizeIndex += 1;
    packages = Arrays.copyOf(packages, getPackagesSize());
  }

  private String sortedRegister(Package packageToRegister) {
    packageToRegister.setAwb(String.format("AWB%d", awbIndex++));
    int index = 0;
    while (index < packagesIndex) {
      if (packages[index].getDeliveryDate().compareTo(packageToRegister.getDeliveryDate()) > 0) {
        break;
      } else if (packages[index].getDeliveryDate().compareTo(packageToRegister.getDeliveryDate()) == 0 &&
          packages[index].getDestination().compareTo(packageToRegister.getDestination()) > 0) {
        break;
      }
      index++;
    }
    shiftRightPackages(index);
    packages[index] = packageToRegister;
    packagesIndex += 1;
    return packageToRegister.getAwb();
  }

  private void shiftRightPackages(int index) {
    for (int i = packagesIndex + 1; i > index; i--) {
      packages[i] = packages[i - 1];
    }
  }

  private void shiftLeftPackages(int index) {
    for (int i = index; i < packagesIndex - 1; i++) {
      packages[i] = packages[i + 1];
    }
  }
}
