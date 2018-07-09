package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private int seedMoney;

    public LottoGame(int seedMoney) {
        this(seedMoney, new RandomLottoGenerator());
    }

    public LottoGame(int seedMoney, LottoGenerator lottoGenerator) {
        this(seedMoney, null, lottoGenerator);
    }

    public LottoGame(int seedMoney, List<Lotto> manualLottos) {
        this(seedMoney, manualLottos, new RandomLottoGenerator());
    }

    public LottoGame(int seedMoney, List<Lotto> manualLottos, LottoGenerator lottoGenerator) {
        this.seedMoney = seedMoney;
        lottos = new ArrayList<>();
        if (manualLottos == null) {
            lottos.addAll(lottoGenerator.generate(seedMoney / LOTTO_PRICE));
            return;
        }
        lottos.addAll(manualLottos);
        lottos.addAll(lottoGenerator.generate(seedMoney / LOTTO_PRICE - manualLottos.size()));
    }

    public GameResult result(LottoResult lottoResult) {
        PrizeMap prizeMap = makePrizeMap(lottoResult);
        return new GameResult(prizeMap.calculateProfit(seedMoney), prizeMap);
    }

    public PrizeMap makePrizeMap(LottoResult lottoResult) {
        PrizeMap prizeMap = new PrizeMap();

        for (Lotto lotto : lottos) {
            Prize prize = Prize.valueOf(lotto.countIntersection(lottoResult), lotto.hasBonusBall(lottoResult));
            prizeMap.increase(prize);
        }

        return prizeMap;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static void main(String[] args) {
        int seedMoney = InputView.inputSeedMoney();
        int manualNumber = InputView.inputManualNumber(seedMoney);
        LottoGame lottoGame = new LottoGame(seedMoney, Lotto.of(InputView.inputManualLotto(manualNumber)));
        ResultView.printLottos(lottoGame.getLottos(), manualNumber);

        GameResult gameResult = lottoGame.result(InputView.inputLottoResult());

        ResultView.printResult(gameResult);
    }
}
