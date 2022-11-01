package practice.mathematical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CommonFactors {

    public static void main(String[] args) {
        int a1 = 10;
        int a2 = 15;

        int maxNumber = Integer.max(a1, a2);

        Predicate<Integer> numberDivisible = n -> (a1 % n == 0) && (a2 % n == 0);

        IntStream.range(1, maxNumber/2)
                 .filter(numberDivisible::test)
                 .forEach(System.out::println);
    }
}
