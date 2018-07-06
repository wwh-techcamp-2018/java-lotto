package lotto;

import lotto.domain.*;
import lotto.util.DoubleUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoGame {
    private List<Lotto> lottos;
    private int seedMoney;

    public LottoGame(int seedMoney) {
        this(seedMoney, new RandomLottoGenerator());
    }

    public LottoGame(int seedMoney, LottoGenerator lottoGenerator) {
        lottos = generateLottos(seedMoney / 1000, lottoGenerator);
        this.seedMoney = seedMoney;
    }

    private List<Lotto> generateLottos(int numOfLottos, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(lottoGenerator.generate());
        }

        return lottos;
    }

    public GameResult result(LottoResult lottoResult) {
        PrizeMap prizeMap = makePrizeMap(lottoResult);
        return new GameResult(prizeMap.calculateProfit(seedMoney), prizeMap);
    }

    public PrizeMap makePrizeMap(LottoResult lottoResult) {
        PrizeMap prizeMap = new PrizeMap();

        for (Lotto lotto : lottos) {
            Prize prize = Prize.valueOf(lotto.countIntersection(lottoResult));
            prizeMap.increase(prize);
        }

        return prizeMap;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputMoney());
        ResultView.printLottos(lottoGame.getLottos());

        GameResult gameResult = lottoGame.result(InputView.inputLottoResult());

        ResultView.printResult(gameResult);
    }
}
