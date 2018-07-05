package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShuffle {
    private static final int MAX_NUMBER = 45;
    private List<Integer> numberPool = new ArrayList<>();

    public LottoShuffle() {
        for (int i = 0; i < MAX_NUMBER; i++) {
            numberPool.add(i + 1);
        }
    }

    public Lotto getLotto() {
        Collections.shuffle(numberPool);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Lotto.A_LOTTO_COUNT; i++) {
            result.add(numberPool.get(i));
        }
        return new Lotto(result);
    }
}
