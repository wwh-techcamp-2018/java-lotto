package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNo {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int number;
    static Map<Integer, LottoNo> lottoNoPool = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNoPool.put(i, new LottoNo(i));
        }
    }

    public LottoNo(int number) {
        if (!isBoundary(number))
            throw new IllegalArgumentException();
        this.number = number;

    }

    public static boolean isBoundary(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER)
            return true;
        return false;
    }

    public static LottoNo valueOf(int i) {
        return lottoNoPool.get(i);
    }

    public int getNumber() {
        return this.number;
    }
}
