package lotto;

import lotto.generator.RandomLottoGenerator;
import lotto.resource.EarningRate;
import lotto.resource.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import utils.NumberUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Money price = InputView.inputPrice();
        List<Lotto> lottos = LottoGame.repeatGenerateLottoNumber(LottoGame.getTryNumber(price));
        ResultView.printLottoNumber(lottos);

        String winningNumber = InputView.inputWinningLotto();
        List<Rank> ranks = LottoGame.confirmWinning(lottos, Lotto.ofComma(winningNumber));
        EarningRate earningRate = LottoGame.getEarningsRate(price, ranks);

        ResultView.printWinningStats(ranks, earningRate);
    }
}
