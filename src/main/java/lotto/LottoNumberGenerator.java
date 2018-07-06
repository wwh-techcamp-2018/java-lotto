package lotto;

import java.util.*;

public class LottoNumberGenerator {
    private static List<Integer> numbers = new ArrayList<>();
    static {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public static Set<Integer> generateNumbers() {
        Collections.shuffle(numbers);
        return new HashSet<>(numbers.subList(0, 6));
    }
}
