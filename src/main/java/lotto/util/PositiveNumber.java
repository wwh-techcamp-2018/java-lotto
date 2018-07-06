package lotto.util;

public class PositiveNumber {

    private int number;

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public PositiveNumber(String input) {
        this(Integer.parseInt(input));
    }

    public int toInt() {
        return this.number;
    }

}
