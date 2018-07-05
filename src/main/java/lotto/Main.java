package lotto;

import lotto.generator.RandomLottoGenerator;
import lotto.resource.CustomDouble;
import lotto.resource.Positive;
import lotto.view.InputView;
import lotto.view.ResultView;
import utils.NumberUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Positive price = InputView.inputPrice();
        List<Lotto> lottos = LottoGame.repeatGenerateLottoNumber(LottoGame.getTryNumber(price), new RandomLottoGenerator());
        ResultView.printLottoNumber(lottos);

        String winningNumber = InputView.inputWinningLotto();
        List<Rank> ranks = LottoGame.confirmWinning(lottos, new Lotto(NumberUtil.splitString(winningNumber)));
        CustomDouble earningRate = LottoGame.getEarningsRate(price, ranks);

        ResultView.printWinningStats(ranks, earningRate);
    }
}
