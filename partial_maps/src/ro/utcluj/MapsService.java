package ro.utcluj;

import java.util.Arrays;

public class MapsService {

  private int resizeIndex = 1;
  private static final int POI_SIZE = 100;
  private PointOfInterest[] pois = new PointOfInterest[POI_SIZE];
  private int poiIndex;

  public String register(PointOfInterest pointOfInterest) {
    if (pointOfInterest.getId() != null) {
      return "Id already set";
    }
    if (pointOfInterest.getName() == null ||
        pointOfInterest.getType() == null ||
        pointOfInterest.getCoordinate() == null
    ) {
      return "Invalid data";
    }
    if (poiIndex == getPoiSize() - 1) {
      resizePois();
    }
    pointOfInterest.setId(String.format("ID%d", poiIndex));
    pois[poiIndex] = pointOfInterest;
    poiIndex += 1;
    return pointOfInterest.getId();
  }

  public PointOfInterest[] remove(PointOfInterest[] poisToBeRemoved) {
    int removedPackageIdsIndex = 0;
    PointOfInterest[] notRemovedPois = new PointOfInterest[poisToBeRemoved.length];
    for (PointOfInterest poiToBeRemoved : poisToBeRemoved) {
      boolean removed = false;
      if (poiToBeRemoved != null) {
        for (int j = 0; j < poiIndex; j++) {
          PointOfInterest currentPointOfInterest = pois[j];
          if (poiToBeRemoved.getId().equals(currentPointOfInterest.getId())) {
            removed = true;
            shiftLeftPackages(j);
            pois[poiIndex - 1] = null;
            poiIndex -= 1;
            break;
          }
        }
        if (!removed) {
          notRemovedPois[removedPackageIdsIndex++] = poiToBeRemoved;
        }
      }
    }
    return notRemovedPois;
  }

  public PointOfInterest[] findAllByType(PointOfInterestType type) {
    int index = 0;
    PointOfInterest[] foundPois = new PointOfInterest[getPoiSize()];
    for (PointOfInterest pointOfInterest : pois) {
      if (pointOfInterest != null && pointOfInterest.getType().equals(type)) {
        foundPois[index++] = pointOfInterest;
      }
    }
    return foundPois;
  }

  public PointOfInterest[] findAllInArea(Coordinate from, Coordinate to) {
    int index = 0;
    PointOfInterest[] inAreaPois = new PointOfInterest[getPoiSize()];
    Coordinate realFrom = bottomLeft(from, to);
    Coordinate realTo = topRight(from, to);
    for (PointOfInterest pointOfInterest : pois) {
      if (pointOfInterest != null && inArea(pointOfInterest, realFrom, realTo)) {
        inAreaPois[index++] = pointOfInterest;
      }
    }
    return inAreaPois;
  }

  public Double rateById(String id, Double newRating) {
    for (PointOfInterest pointOfInterest : pois) {
      if (pointOfInterest.getId().equals(id)) {
        Double oldRating = pointOfInterest.getRating();
        double updatedRating = (oldRating + newRating) / (pointOfInterest.getNumberOfRatings() + 1);
        pointOfInterest.setRating(updatedRating);
        pointOfInterest.setNumberOfRatings(pointOfInterest.getNumberOfRatings() + 1);
        return updatedRating;
      }
    }
    return Double.MIN_VALUE;
  }

  public void printAll() {
    for (PointOfInterest pointOfInterest : pois) {
      if (pointOfInterest != null) {
        System.out.println(pointOfInterest);
      }
    }
  }

  private int getPoiSize() {
    return POI_SIZE * resizeIndex;
  }

  private void resizePois() {
    resizeIndex += 1;
    pois = Arrays.copyOf(pois, getPoiSize());
  }

  private void shiftLeftPackages(int index) {
    for (int i = index; i < poiIndex - 1; i++) {
      pois[i] = pois[i + 1];
    }
  }

  private Coordinate bottomLeft(Coordinate from, Coordinate to) {
    double minLatitude = Math.min(from.getLatitude(), to.getLatitude());
    double minLongitude = Math.min(from.getLongitude(), to.getLongitude());
    return new Coordinate(minLatitude, minLongitude);
  }

  private Coordinate topRight(Coordinate from, Coordinate to) {
    double maxLatitude = Math.max(from.getLatitude(), to.getLatitude());
    double maxLongitude = Math.max(from.getLongitude(), to.getLongitude());
    return new Coordinate(maxLatitude, maxLongitude);
  }

  private boolean inArea(PointOfInterest pointOfInterest, Coordinate bottomLeft, Coordinate topRight) {
    Coordinate coordinate = pointOfInterest.getCoordinate();
    return coordinate.getLatitude() > bottomLeft.getLatitude() && coordinate.getLatitude() < topRight.getLatitude() &&
        coordinate.getLongitude() > bottomLeft.getLongitude() && coordinate.getLongitude() < topRight.getLongitude();
  }
}
