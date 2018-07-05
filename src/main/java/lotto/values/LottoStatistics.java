package lotto.values;

import lotto.LottoGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics = new HashMap<>();

    public LottoStatistics(List<Lotto> lottoList, Lotto winLotto) {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        Rank rank;
        for (Lotto lotto : lottoList) {
            rank = Rank.valueOf(winLotto.match(lotto));
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    public double getYield() {
        // 상금 / 투자금 * 100
        int totalLottoCount = 0;
        int totalPrice = 0;
        for (Rank rank : Rank.values()) {
            int count = statistics.get(rank);
            totalPrice += count * rank.getPrice();
            totalLottoCount += count;
        }
        return (double) totalPrice / (totalLottoCount * LottoGame.LOTTO_PRICE) * 100;
    }

    public int getCount(Rank rank) {
        return statistics.get(rank);
    }

}
