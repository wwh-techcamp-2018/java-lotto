package lotto.domain;

import java.util.*;

public class LottoShuffle {
    private List<Integer> numberPool = new ArrayList<>();

    public LottoShuffle() {
        for (int i = LottoNo.MIN_NUMBER; i <= LottoNo.MAX_NUMBER; i++) {
            numberPool.add(i);
        }
    }

    public Lotto getLotto() {
        Collections.shuffle(numberPool);
        Set<LottoNo> result = new HashSet<>();
        for (int i = 0; i < Lotto.A_LOTTO_COUNT; i++) {
            result.add(LottoNo.valueOf(numberPool.get(i)));
        }
        return new Lotto(result);

    }
}
