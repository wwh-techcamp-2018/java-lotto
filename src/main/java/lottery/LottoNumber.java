package lottery;

import java.util.Objects;

public class LottoNumber {
    private final static int MIN = 1;
    private final static int MAX = 45;

    private int no;

    public LottoNumber(int no) {
        if (!isValid(no)) throw new IllegalArgumentException();
        this.no = no;
    }

    private boolean isValid(int no) {
        if (no < MIN) return false;
        if (no > MAX) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }
}
