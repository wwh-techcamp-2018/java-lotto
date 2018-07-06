package lotto;

import java.util.HashMap;

public class ResultView {

    public static void printLottoList(LottoContainer lottoContainer) {
        System.out.println(lottoContainer.countLotto() + "개를 구매했습니다.");
        System.out.println(lottoContainer);
    }

    public static void printStatistics(HashMap<PrizeData, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (PrizeData prizeData : PrizeData.values()) {
            sb.append(prizeData.toString().substring(1) + "개 일치 " + "(" + prizeData.getPrizeMoney() + ") - ");
            sb.append(map.get(prizeData.toString()) + "개\n");
        }
        System.out.println(sb.toString());
    }

    public static void printProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다");
    }
}
