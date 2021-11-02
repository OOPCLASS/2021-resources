package ro.utcluj.model;

public class Book extends Product implements Comparable {

  private int numberOfPages;

  public Book(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  @Override
  public String getDescription() {
    return "book";
  }

  @Override
  public int compareTo(Object object) {
    if (object instanceof Book) {
      Book book = (Book) object;
      return this.numberOfPages < book.getNumberOfPages() ? 1 : -1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return "Book{" +
        "numberOfPages=" + numberOfPages +
        "} " + super.toString();
  }
}
