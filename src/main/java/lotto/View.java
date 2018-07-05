package lotto;

import java.util.HashMap;

public class View {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        System.out.println(inputView.inputMessage());
        LottoContainer lottoContainer = new LottoContainer(inputView.inputMoney());

        System.out.println(resultView.lottoListNumber(lottoContainer.countLotto()));
        System.out.println(lottoContainer);

        System.out.println(inputView.lastWeekMessage());

        String[] winNumbers = inputView.lastWeekWinLotto();
        Lotto winLotto = new Lotto(winNumbers);
        LottoStatistics lottoStatistics = new LottoStatistics(lottoContainer);

        HashMap map = lottoStatistics.doStatistics(winLotto);

        System.out.println(resultView.printStatistics(map));
        System.out.println(resultView.printProfitRate(lottoStatistics.getProfitRate(lottoStatistics.getCumulativeMoney(map))));
    }
}
