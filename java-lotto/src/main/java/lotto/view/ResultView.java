package lotto.view;

import lotto.Lotto;
import lotto.Rank;
import lotto.resource.EarningRate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStats(List<Rank> userRanks, EarningRate earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Rank, Integer> stats = new HashMap<>();
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            stats.put(rank, 0);
        }
        for (Rank userRank : userRanks) {
            stats.put(userRank, stats.get(userRank) + 1);
        }
        stats.remove(Rank.MISS);

        for (Rank rank : ranks) {
            checkMiss(rank,stats);
        }
        System.out.println("총 수익률은 " + EarningRate.round(earningRate).getEarningRate() + "%입니다.");
    }

    public static void checkMiss(Rank rank, Map<Rank, Integer> stats){
        if(rank == Rank.MISS)
            return;
        checkSecond(rank,stats);
    }

    public static void checkSecond(Rank rank, Map<Rank, Integer> stats){
        if (rank == Rank.SECOND) {
            System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + rank.getWinningMoney() + "원)- " + stats.get(rank) + "개");
            return;
        }
        printRank(rank, stats);
    }

    public static void printRank(Rank rank, Map<Rank, Integer> stats){
        System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + stats.get(rank) + "개");
    }
}
