package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> matchCounter = new HashMap<Integer, Integer>() {{
        put(LottoState.FORTH.getMatchCount(), 0);
        put(LottoState.THIRD.getMatchCount(), 0);
        put(LottoState.SECOND.getMatchCount(), 0);
        put(LottoState.FIRST.getMatchCount(), 0);
    }};
    private int investMoney;


    public LottoResult(List<Lotto> winners, int investMoney) {
        for (Lotto winner : winners) {
            matchCounter.put(winner.getLottoState().getMatchCount()
                    , matchCounter.get(winner.getLottoState().getMatchCount()) + 1);
        }
        this.investMoney = investMoney;
    }

    public int getTotalReword() {
        int totalReword = 0;
        Iterator<Integer> itr = matchCounter.keySet().iterator();
        int key = 0;
        while (itr.hasNext()) {
            key = itr.next();
            totalReword += LottoState.valueOf(key).getReward() * matchCounter.get(key);
        }

        return totalReword;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append("\n당첨 통계\n");
        result.append("---------\n");

        Iterator<Integer> itr = matchCounter.keySet().iterator();
        int key = 0;
        while (itr.hasNext()) {
            key = itr.next();
            result.append(key + "개 일치 (" + LottoState.valueOf(key).getReward() + ")- " + matchCounter.get(key) + "개\n");
        }
        result.append("총 수익률은 " + String.format("%.1f", getProfit()) + "%입니다.");
        return result.toString();
    }

    public double getProfit() {
        return (double) getTotalReword() / investMoney * 100;
    }
}
