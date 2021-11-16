package ro.utcluj;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * - Implement Pair generic class
 *      - it should have two attributes named 'left' & 'right'
 *      - create a list of pair objects
 * - Perform the following operations on a list, set and map: CRUD - Create, Read, Update, Delete
 *      - add one element
 *      - get one element
 *      - remove one element
 *      - update one element
 * - A User can have multiple Address(es) - create the 2 classes
 *      - choose a collection to store users&addresses objects so that you could
 *      get a list of addresses by a specific user
 *      - choose a different collection to store all the addresses of all users with
 *      no duplicates
 *      - take a look at the implementation of ArrayList.add method and note how the
 *      data structure gets resized. What happens with the data structure on removing elements
 * - Explore java streams (search for online tutorials)
 *      e.g.: https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class Main {

  public static void main(String[] args) {

    IntegerBox integerBox1 = new IntegerBox(123);

    String[] namesVector = new String[10];
    List<String> names = new LinkedList<>();
    names.add("123");
    names.add("123");
    System.out.println(names.size());
    List<String> names1 = new LinkedList<>();
    names1.add("123");

    Set<Person> personSet = new TreeSet<>();
    personSet.add(new Person());
    personSet.add(new Person());
    System.out.println(personSet.size());

    for (int i = 0; i < 10; i++) {
      names.add(String.valueOf(i));
    }

//    for (String name : names) {
//      if (name.equals("0")) {
//        names.remove(name);
//      }
//    }

    Set<IntegerBox> mySet = new HashSet<>();

    IntegerBox firstBox = new IntegerBox(123);
    firstBox.setAttribute("123");
    mySet.add(firstBox);

    IntegerBox secondBox = new IntegerBox(123);
    secondBox.setAttribute("123");
    mySet.add(secondBox);

    System.out.println("boxes equal: " + firstBox.equals(secondBox));
    System.out.println("mySet size: " + mySet.size());

    Iterator<String> iterator = names.iterator();

    while (iterator.hasNext()) {
      String currentName = iterator.next();
      if (currentName.equals("0")) {
        iterator.remove();
      }
    }
  }
}
