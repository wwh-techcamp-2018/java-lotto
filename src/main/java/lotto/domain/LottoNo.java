package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNo {
    public static final int MIN_LOTTO_VALUE = 1;
    public static final int MAX_LOTTO_VALUE = 45;

    private static Map<Integer, LottoNo> lottoNoMap;
    private int value;

    static {
        lottoNoMap = new HashMap<>();
        for (int i = MIN_LOTTO_VALUE; i <= MAX_LOTTO_VALUE; i++) {
            lottoNoMap.put(i, new LottoNo(i));
        }
    }

    private LottoNo(int value) {
        if (value < MIN_LOTTO_VALUE || value > MAX_LOTTO_VALUE) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public static LottoNo of(int value) {
        LottoNo lottoNo = lottoNoMap.get(value);

        if (lottoNo == null) {
            throw new IllegalArgumentException();
        }

        return lottoNo;
    }

    public static LottoNo of(String value) {
        return of(Integer.parseInt(value.trim()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return value == lottoNo.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
