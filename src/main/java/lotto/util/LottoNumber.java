package lotto.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> lottoNumberPool = new HashMap<>();

    public static final int MIN = 1;
    public static final int MAX = 45;

    static{
        for (int i = MIN; i <= MAX; i++) {
            lottoNumberPool.put(i, new LottoNumber(i));
        }
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        isRange(number);
        return lottoNumberPool.get(number);
    }

    private static void isRange(int number) {
        if (number < MIN) {
            throw new RuntimeException();
        }
        if (number > MAX) {
            throw new RuntimeException();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        if (other.getNumber() < this.getNumber()) {
            return 1;
        }
        if (other.getNumber() == this.getNumber()) {
            return 0;
        }
        return -1;
    }
}
