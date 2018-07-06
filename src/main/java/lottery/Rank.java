package lottery;

public enum Rank {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchingCount;
    private int profit;

    Rank(int matchingCount, int profit) {
        this.matchingCount = matchingCount;
        this.profit = profit;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getProfit() {
        return profit;
    }
}
