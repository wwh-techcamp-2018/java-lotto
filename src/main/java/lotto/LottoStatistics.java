package lotto;

import java.util.HashMap;

public class LottoStatistics {

    private LottoContainer lottoContainer;

    public LottoStatistics(LottoContainer lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    public HashMap makeMap() {
        HashMap statistics = new HashMap<PrizeData, Integer>();

        for (PrizeData prizeData : PrizeData.values()) {
            statistics.put(prizeData.toString(), 0);
        }

        return statistics;
    }

    public HashMap doStatistics(Lotto winLotto) {
        HashMap statistics = makeMap();

        for (Lotto lotto : lottoContainer.getLottoContainer()) {
            Integer temp = (Integer) statistics.getOrDefault(lotto.hitLottoNumber(winLotto), 0);
            statistics.put("_" + lotto.hitLottoNumber(winLotto), ++temp);
        }
        return statistics;
    }

    public int getCumulativeMoney(HashMap<PrizeData, Integer> statistics) {
        int sum = 0;

        for (PrizeData prizeData : PrizeData.values()) {
            sum += prizeData.getPrizeMoney() * statistics.get(prizeData.toString());
        }

        return sum;
    }

    public double getProfitRate(int cumulativeMoney) {
        return cumulativeMoney / (lottoContainer.countLotto() * Lotto.LOTTO_PRICE) * 100;
    }
}
