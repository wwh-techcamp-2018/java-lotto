package lotto.view;

import lotto.Lotto;
import lotto.Rank;
import lotto.resource.CustomDouble;

import java.util.List;

public class ResultView {
    public static void printLottoNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStats(List<Rank> ranks, CustomDouble earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int[] stats = new int[7];
        for (Rank rank : ranks) {
            stats[rank.getCountOfMatch()]++;
        }
        for (int i = 3; i < 7; i++) {
            System.out.println((i + "개 일치 (" + Rank.valueOf(i).getWinningMoney() + "원)- " + stats[i] + "개"));
        }


        System.out.println("총 수익률은 " + CustomDouble.round(earningRate).getCustomDouble() + "%입니다.");

    }
}
