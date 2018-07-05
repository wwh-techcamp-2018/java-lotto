package lotto;

import java.util.List;

public class Lotto {
    public static final int LIMIT_WINCOUNT = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        if (numbers.size() != LIMIT_WINCOUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
