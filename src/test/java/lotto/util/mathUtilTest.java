package lotto.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class mathUtilTest {

    @Test
    public void getRandomNumbers() {
        List<Integer> randomNumbers = mathUtil.getRandomNumbers(6);
        for (Integer randomNumber : randomNumbers) {
            System.out.println(randomNumber);
        }
    }
}