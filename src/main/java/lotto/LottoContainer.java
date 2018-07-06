package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoContainer {

    List<Lotto> lottoContainer;

    public LottoContainer(int money) {
        makeLottoContainer(countLottoList(money));
    }

    public LottoContainer(List<Lotto> lottos) {
        this.lottoContainer = lottos;
    }

    public void makeLottoContainer(int numbers) {
        this.lottoContainer = new ArrayList<Lotto>();
        for (int i = 0; i < numbers; i++) {
            this.lottoContainer.add(new Lotto());
        }
    }

    private HashMap<PrizeData, Integer> makeMap() {
        HashMap statistics = new HashMap<PrizeData, Integer>();
        for (PrizeData prizeData : PrizeData.values()) {
            statistics.put(prizeData, 0);
        }

        return statistics;
    }

    public HashMap<PrizeData, Integer> hitLottoNumbers(Lotto winLotto) {
        HashMap<PrizeData, Integer> resultMap = makeMap();
        for (Lotto lotto : lottoContainer) {
            resultMap.merge(PrizeData.match(lotto.hitLottoNumber(winLotto)), 1, Integer::sum);
        }

        return resultMap;
    }

    public int countLotto() {
        return this.lottoContainer.size();
    }

    public int countLottoList(int money) {
        return money / Lotto.LOTTO_PRICE;
    }

    @Override
    public String toString() {
        return this.lottoContainer.stream().map(i -> i.toString()).collect(Collectors.joining("\n"));
    }
}
