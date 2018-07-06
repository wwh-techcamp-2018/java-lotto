package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private Lotto winningLotto;

    public List<Lotto> createLottos(int price) {
        lottos = LottoFactory.createLottoList(price);
        return lottos;
    }

    public Lotto createWinningLotto(String numbers) {
        winningLotto = new Lotto(numbers);
        return winningLotto;
    }

    public static List<LottoResult> getResult(List<Lotto> lottos, Lotto winningLotto) {
        List<LottoResult> lottoResults = initLottoResultList();

        for (LottoResult lottoResult : lottoResults) {
            lottoResult.increment(lottos, winningLotto);
        }

        return lottoResults;
    }

    private static List<LottoResult> initLottoResultList() {
        List<LottoResult> lottoResults = new ArrayList<>();
        Match[] matches = Match.values();
        for (Match match : matches) {
            lottoResults.add(new LottoResult(match));
        }
        return lottoResults;
    }

    public int calculateYield(List<LottoResult> results, int price) {
        int sum = 0;
        for (LottoResult result : results) {
            sum += result.calculateYield();
        }
        return sum / price;
    }
}