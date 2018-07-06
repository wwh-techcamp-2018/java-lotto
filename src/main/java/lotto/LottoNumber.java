package lotto;


public class LottoNumber implements Comparable<LottoNumber> {
    private static final int UPPER_LIMIT = 45;
    private static final int LOWER_LIMIT = 1;

    private final int value;

    LottoNumber(int value) {
        if (!isWithinRange(value))
            throw new IllegalArgumentException();
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isWithinRange(int value) {
        return value <= UPPER_LIMIT && value >= LOWER_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber number = (LottoNumber) o;
        return number.value == value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.getValue();
    }

}
