package lotto;

import lotto.util.mathUtil;

import java.util.List;

public class RandomValueGenerator implements ValueGenerator {
    @Override
    public List<Integer> nextValue() {
        return mathUtil.getRandomNumbers(6);
    }
}
