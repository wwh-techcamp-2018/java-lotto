package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathUtil {

    public static float getPercentage(int num1, int num2) {
        return (float) 100 * num1 / num2;
    }

    public static List<Integer> getRandomNumbers(int count) {
        List<Integer> lottoRange = generateRange(1, 46);
        Collections.shuffle(lottoRange);
        return lottoRange.subList(0, count);
    }

    public static List<Integer> generateRange(int from, int to) {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = from; i < to; i++) {
            numList.add(i);
        }
        return numList;
    }

}
