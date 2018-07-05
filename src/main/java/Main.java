import lotto.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int investMoney = inputView.getMoney();

        LottoGame lottoGame = new LottoGame();
        ResultView resultView = new ResultView();
        resultView.printLottos(lottoGame.buyMaximumLottos(investMoney));
        resultView.printLottoList(lottoGame.getLottoList());

        String winNumbers = inputView.getWinNumbers();
        int earnMoney = lottoGame.getTotalPrize(winNumbers);

        resultView.printStatistics(winNumbers, lottoGame.getLottoList());
        resultView.printRate(LottoGame.getEarningRate(earnMoney, investMoney));
    }

}
