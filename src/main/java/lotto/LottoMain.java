package lotto;

import lotto.values.Lotto;
import lotto.values.WinningLotto;
import lotto.view.GameView;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        int manualLottoNumber = InputView.getManualLottoNumber();
        List<Lotto> manualLottoList = Lotto.ofStringList(InputView.getLottoStrings(manualLottoNumber));
        List<Lotto> autoLottoList = LottoGame.buyLotto(money - manualLottoNumber * LottoGame.LOTTO_PRICE);
        GameView.showLottoList(manualLottoList, autoLottoList);
        Lotto winLotto = new Lotto(InputView.getWinNumber());
        int bonusBallNumber = InputView.getBonusBallNumber();
        WinningLotto winningLotto = new WinningLotto(winLotto, bonusBallNumber);
        manualLottoList.addAll(autoLottoList);
        ResultView.showStatistics(LottoGame.calculateStatistics(manualLottoList, winningLotto));
    }
}
