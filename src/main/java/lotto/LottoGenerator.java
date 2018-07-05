package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    static final int LOTTO_NUM = 6;
    static List<Integer> validNumberSet;

    static {
        validNumberSet = new ArrayList<Integer>();
        for (int i = 0; i < 45; i++) {
            validNumberSet.add(i + 1);
        }
    }

    public static List<Integer> generateNum() {
        Collections.shuffle(validNumberSet);
        return validNumberSet.subList(0, 6);

    }
}
