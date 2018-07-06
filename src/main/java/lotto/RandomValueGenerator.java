package lotto;

import lotto.util.MathUtil;

import java.util.Collections;
import java.util.List;

public class RandomValueGenerator implements ValueGenerator {
    @Override
    public List<Integer> nextValue() {
        List<Integer> resultNums = MathUtil.getRandomNumbers(6);
        Collections.sort(resultNums);
        return resultNums;
    }
}
