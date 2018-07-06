package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private List<Lotto> lottoHolder;
    private int cost;
    private Lotto winnerLotto;

    public LottoGame(int cost) {
        this.cost = cost;
        this.lottoHolder = generateLottoHolder();
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Lotto> getLottoHolder() {
        return this.lottoHolder;
    }

    public void setLottoHolder(List<Lotto> holder) {
        this.lottoHolder = holder;
    }

    public void setWinnerLotto(Lotto lotto) {
        this.winnerLotto = lotto;
    }

    public List<Lotto> generateLottoHolder() {
        List<Lotto> holder = new ArrayList<>();
        for (int i = 0; i < cost / 1000; i++) {
            holder.add(new Lotto());
        }
        return holder;
    }

    public int getPrizeSum(Lotto winnerLotto) {
        int prizeSum = 0;
        for (Lotto lotto : lottoHolder) {
            prizeSum += Rank.getRank(lotto.matchCount(winnerLotto)).getPrize();
        }
        return prizeSum;
    }

    public int getProfitRate(Lotto winnerLotto) {
        return (getPrizeSum(winnerLotto) * 100 / cost);
    }

    public int getMatchCountNumber(int matchCount, Lotto winnerLotto) {
        List<Lotto> matchCountEqualList = this.lottoHolder.stream()
                .filter(lotto -> winnerLotto.matchCount(lotto) == matchCount)
                .collect(Collectors.toList());

        return matchCountEqualList.size();
    }

}
