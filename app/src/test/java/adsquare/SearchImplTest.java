package adsquare;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchImplTest {
    private static Random random = new Random(System.currentTimeMillis());

    @ParameterizedTest(name = "Test #{index}: for provided elements : {0}\n 2nd biggest number should be {1}")
    @MethodSource("provideListOfNumbers")
    public void findBiggestElementShouldReturnExpectedValue(List numbers, Integer expected) {
        //given
        int position = 2;
        Search<Integer> search = new SearchImpl<>();
        //when
        Integer result = search.findBiggestElement(numbers, position);
        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Test #{index}: generated numbers : {0}")
    @MethodSource("generateRandomNumbers")
    public void findBiggestElementComparingWithSort(List<Integer> numbers) {
        //given
        int position = random.nextInt(numbers.size()) + 1;
        //
        List<Integer> sortedCopy = new ArrayList<>(numbers);
        Collections.sort(sortedCopy, Collections.reverseOrder());
        int expected = sortedCopy.get(position - 1);

//        System.out.println("sorted: "+ sortedCopy);
//        System.out.println("position: "+ position);
//        System.out.println("expected: "+ expected);


        Search<Integer> search = new SearchImpl<>();

        //when
        Integer result = search.findBiggestElement(numbers, position);
        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generateRandomNumbers() {
        int maxListSize = 100;
        int maxNumberOfList = random.nextInt(maxListSize) + 2;
        List<Arguments> elementsList = new ArrayList<>();
        for (int i = 0; i < maxNumberOfList; i++) {
            elementsList.add(Arguments.of(random.ints(random.nextInt(maxListSize) + 1)
                                                .boxed().collect(Collectors.toList())));
        }
        return elementsList.stream();
    }

    private static Stream<Arguments> provideListOfNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 5),
                Arguments.of(List.of(6, 5, 4, 3, 2, 1), 5),
                Arguments.of(List.of(2, 1), 1),
                Arguments.of(List.of(1), null),
                Arguments.of(List.of(123, 1, 2, 3, 123735, 4, 7, 46, 1784, 7, 146, 5, 4, 3, 2, 1), 1784)
                        );
    }
}


