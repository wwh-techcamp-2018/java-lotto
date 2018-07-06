package lotto.domain;

import java.util.Map;

public class GameResult {
    private double profit;
    private PrizeMap prizeMap;

    public GameResult(double profit, PrizeMap prizeMap) {
        this.profit = profit;
        this.prizeMap = prizeMap;
    }


    public double getProfit() {
        return profit;
    }

    public Map<Prize, Integer> getPrizeMap() {
        return prizeMap.get();
    }

}
