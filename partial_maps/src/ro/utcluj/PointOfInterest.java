package ro.utcluj;

public abstract class PointOfInterest {
  private String id;
  private String name;
  private PointOfInterestType type;
  private Double rating = 0.0;
  private Long numberOfRatings = 0L;
  private Coordinate coordinate;

  public PointOfInterest(String name, PointOfInterestType type, Coordinate coordinate) {
    this.name = name;
    this.type = type;
    this.coordinate = coordinate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PointOfInterestType getType() {
    return type;
  }

  public void setType(PointOfInterestType type) {
    this.type = type;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public Long getNumberOfRatings() {
    return numberOfRatings;
  }

  public void setNumberOfRatings(Long numberOfRatings) {
    this.numberOfRatings = numberOfRatings;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  @Override
  public String toString() {
    return "PointOfInterest{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", type=" + type +
        ", rating=" + rating +
        ", numberOfRatings=" + numberOfRatings +
        ", coordinate=" + coordinate +
        ", " + getAdditionalInfo() +
        '}';
  }

  protected abstract String getAdditionalInfo();
}
