package lotto.domain;

import java.util.Arrays;

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

        return Arrays.stream(LottoState.values()).filter(lottoState -> lottoState.getMatchCount() == matchCount)
                .findAny()
                .orElse(FAIL);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }

    public static boolean isWinner(int matchCount) {
        return matchCount >= LottoState.FORTH.getMatchCount();
    }
}
