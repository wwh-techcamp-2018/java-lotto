package lotto.domain;

import java.util.Map;

public class GameResult {
    private double profit;
    private Map<Prize, Integer> prizeMap;

    public GameResult(double profit, Map<Prize, Integer> prizeMap) {
        this.profit = profit;
        this.prizeMap = prizeMap;
    }


    public double getProfit() {
        return profit;
    }

    public Map<Prize, Integer> getPrizeMap() {
        return prizeMap;
    }

}
