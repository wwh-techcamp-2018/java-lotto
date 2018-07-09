package lotto.values;

import lotto.LottoGame;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics = new HashMap<>();

    public LottoStatistics(List<Lotto> lottoList, WinningLotto winLotto) {
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

        for (Rank rank : getVisibleRankList()) {
            builder.append(rank.toString()).append(String.format("- %d개\n", this.getCount(rank)));
        }
        return builder.toString();
    }

    private static List<Rank> getVisibleRankList() {
        List<Rank> visibleRank = Arrays.stream(Rank.values())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        visibleRank.remove(Rank.MISS);
        return visibleRank;
    }
}
