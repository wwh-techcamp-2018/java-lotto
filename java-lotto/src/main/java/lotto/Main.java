package lotto;

import lotto.resource.EarningRate;
import lotto.resource.LottoNumber;
import lotto.resource.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import utils.NumberUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Money price = InputView.inputPrice();
        List<Lotto> manualLottos = InputView.inputManualLottoSet(InputView.inputManualLotto());
        List<Lotto> lottos = LottoGame.repeatGenerateLottoNumber(LottoGame.getTryNumber(price));
        lottos.addAll(manualLottos);
        ResultView.printLottoNumber(lottos);

        String winningNumber = InputView.inputWinningLotto();
        LottoNumber bonus = InputView.inputBonus();
        List<Rank> ranks = LottoGame.confirmWinning(lottos, new WinningLotto(Lotto.ofComma(winningNumber), bonus));
        EarningRate earningRate = LottoGame.getEarningsRate(price, ranks);

        ResultView.printWinningStats(ranks, earningRate);
    }
}
