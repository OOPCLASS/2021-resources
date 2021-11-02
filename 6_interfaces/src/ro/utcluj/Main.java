package ro.utcluj;

import ro.utcluj.model.Book;
import ro.utcluj.model.Student;
import ro.utcluj.service.ArraysService;
import ro.utcluj.service.FileStorageService;
import ro.utcluj.service.InMemoryStorageService;
import ro.utcluj.service.StorageService;

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

    ArraysService.sort(books, false);

    for (Book book : books) {
      System.out.println(book);
    }

    Student[] students = new Student[4];
    students[0] = new Student("Alex");
    students[1] = new Student("John");
    students[2] = new Student("Ana");
    students[3] = new Student("Bogdan");

    ArraysService.sort(students, true);

    for (Student student : students) {
      System.out.println(student);
    }

    StorageService storageService = new FileStorageService();
    String address = storageService.store(new Student("Mircea"));
    Student retrievedObject = (Student) storageService.retrieve(address);
  }
}
