package section1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ex1 {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 20).boxed().
                collect(Collectors.toList());

        Predicate<Integer> isOdd = i -> i % 2 == 0;
        Predicate<Integer> isEven = i -> i % 2 == 1;
        Predicate<Integer> greaterThanTen = i -> i >= 10;

        Predicate<Integer> isOddAndGreaterThenTen = isOdd.and(greaterThanTen);
        Predicate<Integer> isEvenOrGreaterThenTen = isEven.or(greaterThanTen);

        List<Integer> evenNumbers =
                list.stream().filter(isEven).
                        collect(Collectors.toList());
        List<Integer> oddNumbers =
                list.stream().filter(isOdd).
                        collect(Collectors.toList());
        List<Integer> numbersGreaterThanTen = list.stream().
                filter(greaterThanTen).collect(Collectors.toList());
        List<Integer> oddNumbersAndGreaterThanTen = list.stream()
                .filter(isOddAndGreaterThenTen).collect(Collectors.toList());
        List<Integer> evenNumbersOrGreaterThanTen = list.stream()
                        .filter(isEvenOrGreaterThenTen).collect(Collectors.toList());

        System.out.println("Original list: " + list);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Number greater than 10: " + numbersGreaterThanTen);
        System.out.println("Odd And more than 10: " + oddNumbersAndGreaterThanTen);
        System.out.println(evenNumbersOrGreaterThanTen);
    };

}
