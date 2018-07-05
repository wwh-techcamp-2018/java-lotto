package lotto.resource;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private Integer lottoNumber;

    public LottoNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException();
        }
        this.lottoNumber = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber.compareTo(o.getLottoNumber());
    }
}
