package ro.utcluj;

import ro.utcluj.model.Movie;
import ro.utcluj.model.Product;
import ro.utcluj.second.Book;

/**
 * Create a hierarchy of products with some classes having
 * two levels of inheritance.
 *
 * - create some products of different types and add
 *   them to the same array
 * - create a method which returns the products of a
 *   specific type from the list of all products
 * - implement some overriden & overloaded methods
 * - try out equals on different classes
 * - draw the UML diagram for your classes
 */
public class Main {

  public static void main(String[] args) {
    Book book = new Book();
    book.setTitle("Random book");
    book.setNumberOfPages(10);

    Movie first = new Movie();
    first.setTitle("Movie title");
    first.setRating(10.0);
    first.setLengthInMinutes(10);

    Product second = new Movie();
    second.setTitle("Movie title");

    System.out.println(first instanceof Movie);
    System.out.println(first instanceof Product);
    System.out.println(first instanceof Object);

    Product[] products = new Product[10];
    products[0] = book;
    products[1] = second;

    for (int i = 0; i < 2; i++) {
      Product product = products[i];
      System.out.println(product.getTitle());
      System.out.println(product.getDescription());
    }

    System.out.println("SOS I'm dying!");


  }
}
