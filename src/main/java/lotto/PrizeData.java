package lotto;

import java.util.Arrays;

public enum PrizeData {

    NONE(0,0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int count;
    private int prizeMoney;

    PrizeData(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeData match(int matchCount) {
        return Arrays.stream(PrizeData.values()).filter(prizeData -> prizeData.count == matchCount).findFirst().orElse(PrizeData.NONE);
    }


    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public int calculate(PrizeData prizeData, Integer count) {
        return prizeData.getPrizeMoney() * count;
    }
}
