package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber target) {
        if (number > target.number)
            return 1;
        if (number < target.number)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return number + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
