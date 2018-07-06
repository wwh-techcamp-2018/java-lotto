package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;

import java.util.List;

public class ConsoleOutputView {
    public static void printLottoesInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + "를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        printNewLine();
    }

    public static void printResult(List<LottoResult> lottoResults, int yield) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");

        for (LottoResult lottoResult : lottoResults) {
            System.out.println(lottoResult.getMatch().getMessage()
                    + "-" + lottoResult.getCount() + "개");
        }

        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private static void printNewLine() {
        System.out.println();
    }
}