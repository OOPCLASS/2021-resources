package ro.utcluj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    // List<String> names = new ArrayList<>();
    List<String> names = new ArrayList<>();
    Map<String, IntegerBox> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      names.add(String.valueOf(i));
    }

//    for (String name : names) {
//      if (name.equals("0")) {
//        names.remove(name);
//      }
//    }

    Iterator<String> iterator = names.iterator();

    while (iterator.hasNext()) {
      String currentName = iterator.next();
      if (currentName.equals("0")) {
        iterator.remove();
      }
    }
  }
}
