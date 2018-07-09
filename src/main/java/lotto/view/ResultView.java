package lotto.view;

import lotto.values.LottoStatistics;

public class ResultView {
    public static void showStatistics(LottoStatistics statistics){
        System.out.println("\n당첨 통계");
        System.out.println("--------------");
        System.out.println(statistics);
        System.out.printf("총 수익율은 %.1f%%입니다.\n", statistics.getYield());
    }
}
