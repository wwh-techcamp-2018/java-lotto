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
            rank = winLotto.match(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    public double getYield() {
        return calculateYield(calculateTotalPrice(), calculateTotalCount());
    }

    private double calculateYield(int totalPrice, int totalLottoCount) {
        return (double) totalPrice / (totalLottoCount * LottoGame.LOTTO_PRICE) * 100;
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (Rank rank : Rank.values()) {
            totalPrice += rank.getTotalPrice(getCount(rank));
        }
        return totalPrice;
    }

    private int calculateTotalCount() {
        int totalCount = 0;
        for (Rank rank : Rank.values()) {
            totalCount += getCount(rank);
        }
        return totalCount;
    }

    private int getCount(Rank rank) {
        return statistics.get(rank);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Rank rank;
        for (int matches = Rank.FOURTH.getMatches(); matches <= Rank.FIRST.getMatches() ; matches++) {
            rank = Rank.valueOf(matches);
            builder.append(String.format("%d개 일치(%d원)- %d개\n",
                    rank.getMatches(),
                    rank.getPrice(),
                    this.getCount(rank)));
        }
        return builder.toString();
    }
}
