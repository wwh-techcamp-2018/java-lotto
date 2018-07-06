package lotto;

import java.util.Objects;

public class LottoNumber {
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)
            throw new IllegalArgumentException("로또 숫자는 1~45까지 숫자만 가능합니다.");
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }
}
