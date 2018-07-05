package lotto;

import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.util.DoubleUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoGame {
    private List<Lotto> lottos;
    private int money;

    public LottoGame(int money) {
        this(money, new RandomLottoGenerator());
    }

    public LottoGame(int money, LottoGenerator lottoGenerator) {
        lottos = generateLottos(money / 1000, lottoGenerator);
        this.money = money;
    }

    private List<Lotto> generateLottos(int numOfLottos, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(lottoGenerator.generate());
        }

        return lottos;
    }

    public GameResult result(LottoResult lottoResult) {
        Map<Prize, Integer> prizeMap = makePrizeMap(lottoResult);
        return new GameResult(calculateProfit(prizeMap), prizeMap);
    }

    public Map<Prize, Integer> makePrizeMap(LottoResult lottoResult) {
        Map<Prize, Integer> prizeMap = new HashMap<Prize, Integer>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.GGWANG, 0);
        }};

        for (Lotto lotto : lottos) {
            Prize prize = Prize.valueOf(lotto.countIntersection(lottoResult));
            prizeMap.put(prize, prizeMap.get(prize) + 1);
        }

        return prizeMap;
    }

    private double calculateProfit(Map<Prize, Integer> prizeMap) {
        return DoubleUtil.roundToOneDecimal(Stream.of(Prize.values())
                .mapToLong(prize -> prize.compute(prizeMap.get(prize))).sum() / (double) money * 100);
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
