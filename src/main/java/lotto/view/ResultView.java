package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printResult(GameResult gameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printPrizeMap(gameResult.getPrizeMap());
        System.out.println("총 수익률은 " + gameResult.getProfit() + "%입니다.");
    }

    private static void printPrizeMap(Map<Prize, Integer> prizeMap) {
        prizeMap.remove(Prize.GGWANG);

        prizeMap.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> (int) entry.getKey().getReward()))
                .forEach(entity -> {
                    Prize prize = entity.getKey();
                    System.out.printf("%s-\t%d개\n", prize.expressionString(), prizeMap.get(prize));
                });
    }

    public static void printLottos(List<Lotto> lottos, int manualNumber) {
        System.out.println("수동으로 " + manualNumber + "장, 자동으로 " + (lottos.size() - manualNumber) + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
