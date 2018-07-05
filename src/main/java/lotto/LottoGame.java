package lotto;

import lotto.values.Lotto;
import lotto.values.LottoStatistics;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buyLotto(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public static LottoStatistics calculateStatistics(List<Lotto> lottoList, Lotto winLotto) {
        return new LottoStatistics(lottoList, winLotto);
    }
}
