import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int money = inputView.getMoney();

        LottoGame lottoGame = new LottoGame();
        lottoGame.setMoney(money);
        lottoGame.buyMaximumLottos();

        ResultView resultView = new ResultView(lottoGame.getLottoDTO());
        resultView.printLottoList();

        String winNumbers = inputView.getWinNumbers();
        lottoGame.setWinLotto(Lotto.of(winNumbers));
        lottoGame.makeStatistics();
        lottoGame.calculateEarningRate();

        resultView.printStatistics();
        resultView.printRate();
    }

}
