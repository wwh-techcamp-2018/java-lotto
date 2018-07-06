package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGenerator implements Generator {

    public static final int LIMIT_NUMBER = 45;
    public static final int LIMIT_LOTTOCOUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> list = Arrays.asList(getIntegers());
        Collections.shuffle(list);
        return list.subList(0, LIMIT_LOTTOCOUNT);
    }

    private Integer[] getIntegers() {
        Integer[] candidates = new Integer[LIMIT_NUMBER];
        for (int i = 0; i < LIMIT_NUMBER; i++) {
            candidates[i] = i + 1;
        }
        return candidates;
    }

}
