package ro.utcluj.service;

import ro.utcluj.model.Comparable;

public class ArraysService {

  public static void sort(Comparable[] array, boolean reversed) {
    int n = array.length;

    // One by one move boundary of unsorted subarray
    for (int i = 0; i < n - 1; i++) {
      // Find the minimum element in unsorted array
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (!reversed && array[j].compareTo(array[minIndex]) < 0) {
          minIndex = j;
        } else if (reversed && array[j].compareTo(array[minIndex]) > 0) {
          minIndex = j;
        }
      }

      // Swap the found minimum element with the first
      // element
      Comparable temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
  }
}
