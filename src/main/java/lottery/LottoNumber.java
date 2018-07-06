package lottery;

import java.util.Objects;

public class LottoNumber {
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_LENGTH = 6;

    private int number;

    public LottoNumber(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER)
            throw new IllegalArgumentException();
        this.number = number;
    }

    public int toInt() {
        return number;
    }

    @Override
    public String toString() {
        return "" + number;
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
}
