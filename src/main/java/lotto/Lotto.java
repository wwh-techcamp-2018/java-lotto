package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        this(selectNumber(createNumber()));
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = sorted(numbers);
    }

    static List<Integer> sorted(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public static List<Integer> createNumber() {
        List<Integer> lotto = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(lotto);
        return lotto;
    }

    public static List<Integer> selectNumber(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Integer existCount(List<Integer> winnerNumbers) {
        return winnerNumbers.stream()
                .filter(t -> numbers.contains(t))
                .collect(Collectors.toList())
                .size();
    }
}
