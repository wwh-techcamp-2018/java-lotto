package lotto;

import java.util.Collections;
import java.util.List;

public class ResultView {
    private static final int START = 3;
    private static final int[] PRIZE_MONEY = {0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000};

    public static void printLottos(LottoPlay game) {
        List<Lotto> lottos = game.getLottos();
        for (int i = 0; i < lottos.size(); i++) {
            getPrintLotto(lottos.get(i));
        }
    }

    private static void getPrintLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계\n----------");
        for (int i = START; i < 7; i++) {
            System.out.println(i + "개 일치 (" + PRIZE_MONEY[i] + "원)-" + result.getResult(i) + "개");
        }
    }

    public static void printBenefit(LottoResult result, LottoPlay game) {
        // 상금/투자금*100
        System.out.println("총 수익률은 " + sumPrizeMoney(result) / game.getLottos().size() / 10 + "%입니다.");
    }

    private static int sumPrizeMoney(LottoResult result) {
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            sum += PRIZE_MONEY[i] * result.getResult(i);
        }
        return sum;
    }
}
