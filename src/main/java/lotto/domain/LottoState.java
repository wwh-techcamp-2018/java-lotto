package lotto.domain;

public enum LottoState {
    FIRST(6, 200000000),
    SECOND(5, 15000000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    FAIL(0, 0);

    private final int matchCount;
    private final int reward;

    LottoState(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }


    public static LottoState valueOf(int matchCount) {
        if (matchCount == 6)
            return FIRST;
        if (matchCount == 5)
            return SECOND;
        if (matchCount == 4)
            return THIRD;
        if (matchCount == 3)
            return FORTH;

        return FAIL;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }
}
