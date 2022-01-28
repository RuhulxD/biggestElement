/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package adsquare;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // No argument process or reading from any input source implemented yet.

        Search<Integer> search = new SearchImpl<>();
        List<Integer> numbers = List.of(10, 20, 30, 40, 11, 51, 50, 1, 2, 3, 4);
        int position = 2;
        System.out.println("From the list of: " + numbers);
        System.out.println(position + (position % 10 == 1 ? "st" : position % 10 == 2 ? "nd" : "th") +
                           " biggest element is: " + search.findBiggestElement(numbers, position));

    }
}
