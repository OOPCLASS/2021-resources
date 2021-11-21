package ro.utcluj;

public class PropertyService implements ReportService {

  public static final int PROPERTIES_SIZE = 100;
  private Property propertyWithLowestPrice = null;
  private Property[] properties = new Property[PROPERTIES_SIZE];
  private int propertyIndex = 0;
  private Long identificationNumber = 0L;

  public String register(Property property) {
    if (property.getIdentificationNumber() != null) {
      return "Identification number already assigned";
    }
    if (property.getCity() == null || property.getPrice() == null || property.getSurface() == null) {
      return "Invalid data";
    }
    if (propertyIndex == PROPERTIES_SIZE - 1) {
      Property[] propertiesToRemove = new Property[1];
      propertiesToRemove[0] = propertyWithLowestPrice;
      remove(propertiesToRemove);
    }
    return sortedRegister(property);
  }

  public Property[] findAllByPricePerSqmBetween(Double from, Double to) {
    Property[] result = new Property[PROPERTIES_SIZE];
    int resultIndex = 0;
    if (from == null) {
      from = Double.MIN_VALUE;
    }
    if (to == null) {
      to = Double.MAX_VALUE;
    }
    for (Property property : properties) {
      if (property != null) {
        double currentPropertyPPS = property.getPrice() / property.getSurface();
        if (from <= currentPropertyPPS && to >= currentPropertyPPS) {
          result[resultIndex++] = property;
        }
      }
    }
    return result;
  }

  public Long[] remove(Property[] propertiesToBeRemoved) {
    int removedPropertyIdsIndex = 0;
    Long[] notRemovedPropertyIds = new Long[propertiesToBeRemoved.length];
    for (Property propertyToBeRemoved : propertiesToBeRemoved) {
      boolean removed = false;
      if (propertyToBeRemoved != null) {
        for (int j = 0; j < propertyIndex; j++) {
          Property currentProperty = properties[j];
          if (propertyToBeRemoved.getIdentificationNumber().equals(currentProperty.getIdentificationNumber())) {
            removed = true;
            shiftLeftProperties(j);
            properties[propertyIndex - 1] = null;
            propertyIndex -= 1;
            break;
          }
        }
        if (!removed) {
          notRemovedPropertyIds[removedPropertyIdsIndex++] = propertyToBeRemoved.getIdentificationNumber();
        }
      }
    }
    return notRemovedPropertyIds;
  }

  private String sortedRegister(Property property) {
    updatePropertyWithLowestPrice(property);
    property.setIdentificationNumber(identificationNumber++);
    int index = 0;
    while (index < propertyIndex) {
      if (properties[index].getCity().compareTo(property.getCity()) > 0) {
        break;
      } else if (properties[index].getCity().compareTo(property.getCity()) == 0 &&
          properties[index].getPrice().compareTo(property.getPrice()) > 0) {
        break;
      }
      index++;
    }
    shiftRightProperties(index);
    properties[index] = property;
    propertyIndex += 1;
    return String.valueOf(property.getIdentificationNumber());
  }

  private void shiftRightProperties(int index) {
    for (int i = propertyIndex + 1; i > index; i--) {
      properties[i] = properties[i - 1];
    }
  }

  private void shiftLeftProperties(int index) {
    for (int i = index; i < propertyIndex - 1; i++) {
      properties[i] = properties[i + 1];
    }
  }

  private void updatePropertyWithLowestPrice(Property property) {
    if (propertyWithLowestPrice == null) {
      propertyWithLowestPrice = property;
    } else if (propertyWithLowestPrice.getPrice() > property.getPrice()) {
      propertyWithLowestPrice = property;
    }
  }

  @Override
  public void printReport() {
    PropertyReport[] report = toReport();
    for (int i = 0; i < report.length; i++) {
      if (report[i] != null) {
        report[i].printReport(i + 1);
      }
    }
  }

  private PropertyReport[] toReport() {
    int reportsIndex = 0;
    PropertyReport[] reports = new PropertyReport[PROPERTIES_SIZE];
    for (Property property : properties) {
      boolean propertyAdded = false;
      for (int i = 0; i < reportsIndex && property != null; i++) {
        PropertyReport report = reports[i];
        if (report != null && report.getCity().equals(property.getCity())) {
          propertyAdded = true;
          report.addProperty(property);
        }
      }
      if (!propertyAdded && property != null) {
        PropertyReport propertyReport = new PropertyReport(property.getCity());
        propertyReport.addProperty(property);
        reports[reportsIndex++] = propertyReport;
      }
    }
    return reports;
  }
}
