package lotto.values;

import java.util.Objects;

public class LottoNumber {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private int number;
    public LottoNumber(int number) {
        if (LOWER_BOUND > number || UPPER_BOUND < number) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public int toInt() {
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
        return String.valueOf(this.number);
    }
}
