package lotto;

public enum Match {
    THIRD(3, 5000, "3개 일치 (5000원)"),
    FOURTH(4, 50000, "4개 일치 (50000원)"),
    FIFTH(5, 1500000, "5개 일치 (1500000원)"),
    SIXTH(6, 200000000, "6개 일치 (2000000000원)");

    private int matchCount;
    private int price;
    private String message;

    Match(int matchCount, int price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public static Match ofMatch(int matchCount) {
        Match[] matches = Match.values();
        for (Match match : matches) {
            if (isSame(match, matchCount)) {
                return match;
            }
        }
        return null;
    }

    public static boolean isSame(Match match, int matchCount) {
        return match.getMatchCount() == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public int calculateYield(int count) {
        return this.price * count;
    }
}