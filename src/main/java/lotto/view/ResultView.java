package lotto.view;

import lotto.Lotto;
import lotto.LottoPrize;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultView {

    public void printLottos(int result) {
        System.out.println(result + "개를 구매했습니다.");
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public void printRate(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }

    public void printStatistics(String winLottoNumbers, List<Lotto> lottoList) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int[] prizeCount = new int[LottoPrize.CORRECT_TYPES];

        for (Lotto lotto : lottoList) {
            int correct = lotto.getCorrectCount(winLottoNumbers);
            prizeCount[correct] += 1;
        }

        for (int i = 3; i < LottoPrize.CORRECT_TYPES; i++) {
            LottoPrize prize = new LottoPrize(i);
            System.out.println(prize.toString() + "-" + prizeCount[i] + "개");
        }
    }

}
