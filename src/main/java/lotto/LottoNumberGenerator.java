package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static List<Integer> numbers = new ArrayList<>();
    static {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public static List<Integer> generateNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
