package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN) {
            throw new RuntimeException();
        }
        if (number > LOTTO_MAX) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
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
        if (other.getNumber() > this.getNumber()) {
            return -1;
        }

        return 0;
    }
}
