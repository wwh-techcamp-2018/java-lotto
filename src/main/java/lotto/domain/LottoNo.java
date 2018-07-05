package lotto.domain;

import java.util.Objects;

public class LottoNo {
    private int value;

    public LottoNo(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public LottoNo(String value) {
        this(Integer.parseInt(value.trim()));
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
