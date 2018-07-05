package lotto.domain;

import java.util.*;

public class LottoGame {
    private static final int LOTTO_COST = 1000;

    private final LottoShuffle shuffle;
    private Lotto winLotto;


    public LottoGame() {
        this.shuffle = new LottoShuffle();
    }

    public List<Lotto> generate(int cost) {
        if (cost < LOTTO_COST)
            throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요.");

        int count = getLottoCount(cost);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(shuffle.getLotto());
        }
        return lottos;
    }

    private int getLottoCount(int cost) {
        return cost / LOTTO_COST;
    }

    public void setWinLotto(Lotto winLotto) {
        this.winLotto = winLotto;
    }

    List<Lotto> getWinners(List<Lotto> lottos) {
        List<Lotto> winners = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lotto.setLottoState(winLotto);
            if (lotto.isWinner())
                winners.add(lotto);
        }
        return winners;
    }


    public LottoResult getLottoResult(List<Lotto> lottos) {
        return new LottoResult(getWinners(lottos), (lottos.size() * LOTTO_COST));
    }


}
