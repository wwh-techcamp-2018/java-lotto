package lotto.domain;

import lotto.util.DoubleUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PrizeMap {
    Map<Prize, Integer> prizeMap;

    public PrizeMap() {
        prizeMap = new HashMap<Prize, Integer>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.GGWANG, 0);
        }};
    }

    public void increase(Prize prize) {
        prizeMap.put(prize, prizeMap.get(prize) + 1);
    }

    public Map<Prize, Integer> get() {
        return prizeMap;
    }

    public double calculateProfit(int seedMoney) {
        return DoubleUtil.roundToOneDecimal(Stream.of(Prize.values())
                .mapToLong(prize -> prize.compute(prizeMap.get(prize))).sum() / (double) seedMoney * 100);
    }
}
