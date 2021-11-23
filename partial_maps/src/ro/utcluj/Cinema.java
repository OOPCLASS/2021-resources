package ro.utcluj;

import java.util.Arrays;

public class Cinema extends PointOfInterest {

  private String[] movies;

  public Cinema(String name, Coordinate coordinate, String[] movies) {
    super(name, PointOfInterestType.CINEMA, coordinate);
    this.movies = movies;
  }

  public String[] getMovies() {
    return movies;
  }

  public void setMovies(String[] movies) {
    this.movies = movies;
  }

  public String getAdditionalInfo() {
    return "movies=" + Arrays.toString(movies);
  }
}
