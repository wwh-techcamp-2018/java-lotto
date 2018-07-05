public class LottoNumber {
    private final int value;

    private static final int UPPER_LIMIT = 45;
    private static final int LOWER_LIMIT = 1;

    LottoNumber(int value) {
        if(!isWithinRange(value)) throw new IllegalArgumentException();
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
}
