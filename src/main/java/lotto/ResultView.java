package lotto;

import java.util.HashMap;

public class ResultView {

    public String lottoListNumber(int number) {
        return number + "개를 구매했습니다.";
    }

    public String printStatistics(HashMap<PrizeData, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (PrizeData prizeData : PrizeData.values()) {
            sb.append(prizeData.toString().substring(1) + "개 일치 " + "(" + prizeData.getPrizeMoney() + ") - ");
            sb.append(map.get(prizeData.toString()) + "개\n");
        }
        return sb.toString();
    }

    public String printProfitRate(double rate) {
        return "총 수익률은 " + rate + "%입니다";
    }
}
