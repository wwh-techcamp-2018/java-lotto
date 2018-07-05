package lotto;

public enum Match {
    THIRD(3, 5000), FOURTH(4, 50000), FIFTH(5, 1500000), SIXTH(6, 200000000);

    private int matchCount;
    private int price;

    Match(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount(int matchCount) {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }
}
