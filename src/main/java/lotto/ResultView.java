package lotto;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printStatistics(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "개 일치 (" + WinPrize.getPrize(e.getKey()) + ") - " + e.getValue() + "개");
        }
    }

    public static void printProfit(int sum, int money) {
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", (float) sum/money*100));
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size()+ "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
