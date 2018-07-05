package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    static final int LOTTO_PRICE = 1000;

    public List<Lotto> createLotto(int money) {
        List<Lotto> newLottoes = new ArrayList<Lotto>();
        for (int i = 0; i < maxLottoToBuy(money); i++) {
            newLottoes.add(new Lotto());
        }
        return newLottoes;
    }

    int maxLottoToBuy(int money) {
        if (money < LOTTO_PRICE) {
            return 0;
        }
        return money / LOTTO_PRICE;
    }
}
