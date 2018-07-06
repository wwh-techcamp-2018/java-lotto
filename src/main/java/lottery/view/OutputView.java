package lottery.view;

import lottery.Lottery;

import java.util.List;

public class OutputView {

    public static void printLotteries(List<Lottery> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.toString());
        }
    }

    public static void printWinningStatistic(String winningStatistic) {
        System.out.println("당첨 통계");
        System.out.println("-------");
        System.out.println(winningStatistic);
    }

    public static void printTotalRatio(double ratio) {
        System.out.printf("총 수익률은 %.1f", ratio);
        System.out.println("%입니다.");
    }
}
