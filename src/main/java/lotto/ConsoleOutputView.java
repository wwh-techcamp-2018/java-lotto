package lotto;

import java.util.List;

public class ConsoleOutputView {
    public static void printLottoesInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + "를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult(LottoGameResult lottoGameResult, int price) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");

        int[] matchCountArr = lottoGameResult.getMatchCountArr();

        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치  (" + Match.values()[i - 3].getPrice() + "원 ) -  " + matchCountArr[i] + "개");
        }

        System.out.println("총 수익률은 " + (lottoGameResult.getTotalReward() / price * 100) + "%입니다.");
    }
}
