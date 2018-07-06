package lotto;

import lotto.util.MapUtil;

import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> resultnums;
    private static final int PRIZE_3 = 5000;
    private static final int PRIZE_4 = 50000;
    private static final int PRIZE_5 = 1500000;
    private static final int PRIZE_6 = 2000000000;

    public LottoResult() {
        this.resultnums = MapUtil.mapBuilder(new int[]{3, 4, 5, 6}, new int[]{0, 0, 0, 0});

    }

    public LottoResult(int[] resultnums) {
        this.resultnums = MapUtil.mapBuilder(new int[]{3, 4, 5, 6}, resultnums);
    }

    public Map<Integer, Integer> addResult(int matches) {
        if (!resultnums.keySet().contains(matches))
            return resultnums;
        resultnums.put(matches, resultnums.get(matches) + 1);
        return resultnums;
    }


    public Map<Integer, Integer> getResult() {
        return this.resultnums;
    }

    public int getSum() {
        int sum = 0;
        sum += resultnums.get(3) * PRIZE_3
                + resultnums.get(4) * PRIZE_4
                + resultnums.get(5) * PRIZE_5
                + resultnums.get(6) * PRIZE_6;
        return sum;
    }
}
