package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    GGWANG(0, 0);

    private int matchCount;
    private long reward;

    Prize(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Prize valueOf(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(GGWANG);
    }

    public long compute(int matchCount) {
        return matchCount * reward;
    }

}
