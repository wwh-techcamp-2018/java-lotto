package lotto;

import java.util.HashMap;

public class View {

    public static void main(String[] args) {

        LottoContainer lottoContainer = new LottoContainer(InputView.inputMoney());

        ResultView.printLottoList(lottoContainer);

        Lotto winLotto = new Lotto(InputView.lastWeekWinLotto());
        LottoStatistics lottoStatistics = new LottoStatistics(lottoContainer);

        HashMap map = lottoStatistics.doStatistics(winLotto);

        ResultView.printStatistics(map);
        ResultView.printProfitRate(lottoStatistics.getProfitRate(lottoStatistics.getCumulativeMoney(map)));
    }
}
