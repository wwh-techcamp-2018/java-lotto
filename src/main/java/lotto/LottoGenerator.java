package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int NUMBER_LOWER_BOUND = 1;
    public static final int NUMBER_UPPER_BOUND = 45;
    static List<Integer> validNumberSet;

    static {
        validNumberSet = new ArrayList<Integer>();
        for (int i = NUMBER_LOWER_BOUND ; i < NUMBER_UPPER_BOUND; i++) {
            validNumberSet.add(i + 1);
        }
    }

    public static List<Integer> generateNum() {
        Collections.shuffle(validNumberSet, new Random(System.currentTimeMillis()));
        List<Integer> result = new ArrayList(validNumberSet.subList(0, LOTTO_NUMBER_COUNT));
        Collections.sort(result);
        return result;
    }
}
