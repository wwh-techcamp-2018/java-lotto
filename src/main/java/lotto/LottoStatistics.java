package lotto;

import java.util.HashMap;

public class LottoStatistics {

    private LottoContainer lottoContainer;
    private HashMap<PrizeData, Integer> results;

    public LottoStatistics(LottoContainer lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    private HashMap<PrizeData, Integer> makeMap() {
        HashMap statistics = new HashMap<PrizeData, Integer>();
        for (PrizeData prizeData : PrizeData.values()) {
            statistics.put(prizeData, 0);
        }

        return statistics;
    }

    public HashMap<PrizeData, Integer> doStatistics(Lotto winLotto) {
        this.results = lottoContainer.hitLottoNumbers(winLotto);
        return results;
    }

    public int getCumulativeMoney(HashMap<PrizeData, Integer> statistics) {
        int sum = 0;

        for (PrizeData prizeData : PrizeData.values()) {
            sum += prizeData.calculate(prizeData, statistics.get(prizeData));
        }

        return sum;
    }

    public double getProfitRate(int cumulativeMoney) {
        return cumulativeMoney / (lottoContainer.countLotto() * Lotto.LOTTO_PRICE) * 100;
    }
}
