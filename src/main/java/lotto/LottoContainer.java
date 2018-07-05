package lotto;

import java.util.ArrayList;
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
            lottoContainer.add(new Lotto());
        }
    }

    public int countLotto() {
        return this.lottoContainer.size();
    }

    public int countLottoList(int money) {
        return money / Lotto.LOTTO_PRICE;
    }

    public List<Lotto> getLottoContainer() {
        return lottoContainer;
    }

    @Override
    public String toString() {
        return lottoContainer.stream().map(i -> i.toString()).collect(Collectors.joining("\n"));
    }
}
