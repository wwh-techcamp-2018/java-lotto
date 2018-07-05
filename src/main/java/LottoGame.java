import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private LottoGameDisplay lottoGameDisplay;
    private List<Lotto> lottoHolder;
    private int cost;
    private Lotto winnerLotto;

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

    public void generateGame() {
        lottoGameDisplay = new LottoGameDisplay(this);
    }

    public List<Lotto> generateLottoHolder() {
        List<Lotto> holder = new ArrayList<>();
        for (int i = 0; i < cost / 1000; i++) {
            holder.add(new Lotto());
        }
        return holder;
    }

    public int getPrizeSum() {
        int prizeSum = 0;
        for (Lotto lotto : lottoHolder) {
            prizeSum += Rank.getMatchingPrize(lotto.matchCount(winnerLotto));
        }
        return prizeSum;
    }

    public int getProfitRate() {
        return (getPrizeSum() * 100 / cost);
    }

    public int getMatchCountNumber(int matchCount) {
        List<Lotto> matchCountEqualList = this.lottoHolder.stream()
                .filter(lotto -> this.winnerLotto.matchCount(lotto) == matchCount)
                .collect(Collectors.toList());

        return matchCountEqualList.size();
    }

    public void run() {
        generateGame();
    }
}
