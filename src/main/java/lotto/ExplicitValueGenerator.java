package lotto;

import java.util.Collections;
import java.util.List;

public class ExplicitValueGenerator implements ValueGenerator {
    private List<List<Integer>> numbers;
    private int index;

    public ExplicitValueGenerator(List<List<Integer>> numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public List<Integer> nextValue() {
        List<Integer> resultNums = this.numbers.get(index);
        Collections.sort(resultNums);
        index++;
        return resultNums;
    }
}
