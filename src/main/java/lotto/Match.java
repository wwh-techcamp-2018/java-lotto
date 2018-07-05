package lotto;

public enum Match {
    THIRD(5000), FOURTH(50000), FIFTH(1500000), SIXTH(200000000);

    private int price;

    Match(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
