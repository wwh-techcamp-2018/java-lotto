package lotto.util;

import org.junit.Test;

import java.util.List;

public class MathUtilTest {

    @Test
    public void getRandomNumbers() {
        List<Integer> randomNumbers = MathUtil.getRandomNumbers(6);
        for (Integer randomNumber : randomNumbers) {
            System.out.println(randomNumber);
        }
    }
}