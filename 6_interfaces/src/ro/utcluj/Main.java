package ro.utcluj;

public class Main {

  public static void main(String[] args) {
    Book first = new Book(10);
    Book second = new Book(5);
    Book third = new Book(7);
    Book fourth = new Book(8);

    Book[] books = new Book[4];
    books[0] = first;
    books[1] = second;
    books[2] = third;
    books[3] = fourth;

    ArraysService.sort(books);

    for (Book book : books) {
      System.out.println(book);
    }
  }
}
