package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
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

    public static Prize valueOf(int matchCount, boolean bonusBallMatch) {
        Prize result = Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(GGWANG);

        if (result == SECOND && !bonusBallMatch) {
            return Prize.THIRD;
        }

        return result;
    }

    public long compute(int matchCount) {
        return matchCount * reward;
    }

    public String expressionString() {
        if (this == Prize.SECOND) {
            return "5개 일치, 보너스 볼 일치(30000000원)";
        }
        return String.format("%d개 일치 (%d원)", matchCount, reward);
    }
}
