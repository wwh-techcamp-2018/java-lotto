package lotto;

import lotto.values.Lotto;
import lotto.view.GameView;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        List<Lotto> lottoList = LottoGame.buyLotto(money);
        GameView.showLottoList(lottoList);
        Lotto winLotto = new Lotto(InputView.getWinNumber());
        ResultView.showStatistics(LottoGame.calculateStatistics(lottoList, winLotto));
    }
}
