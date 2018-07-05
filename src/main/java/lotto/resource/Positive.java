package lotto.resource;

public class Positive {
    private Integer number;

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public Positive(String inputString) {
        this(Integer.parseInt(inputString));
    }

    public Integer getNumber() {
        return number;
    }
}
