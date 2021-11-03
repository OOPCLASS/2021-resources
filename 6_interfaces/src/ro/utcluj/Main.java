package ro.utcluj;

import ro.utcluj.model.Book;
import ro.utcluj.model.Movie;
import ro.utcluj.model.Product;

public class Main {

  public static void main(final String[] args) {
    final Product book = new Book(1);
    Product movie = new Movie();

    System.out.println(book.getDescription());
    System.out.println(movie.getDescription());

    book.describeYourself();
    movie.describeYourself();


  }
}
