package lotto.view;

import lotto.values.LottoStatistics;
import lotto.values.Rank;

public class ResultView {
    public static void showStatistics(LottoStatistics statistics){
        System.out.println("\n당첨 통계");
        System.out.println("--------------");
        Rank rank;
        for (int matches = Rank.FOURTH.getMatches(); matches <= Rank.FIRST.getMatches() ; matches++) {
            rank = Rank.valueOf(matches);
            System.out.printf("%d개 일치(%d원)- %d개\n", rank.getMatches(), rank.getPrice(), statistics.getCount(rank));
        }

        System.out.printf("총 수익율은 %.1f%%입니다.\n", statistics.getYield());
    }
}
