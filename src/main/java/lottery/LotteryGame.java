package lottery;

import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LotteryGame {
    private static final String SEPARATOR = ",";

    public void run() {
        InputView inputView = new InputView();
        int money = toInt(inputView.inputMoney());

        User user = new User();
        List<Lottery> lotteries = user.buyLottery(money);

        OutputView.printLotteries(lotteries);

        WinningLottery winningLottery = createWinningLottery(inputView.inputWinningLottery());

        WinningResult winningResult = new WinningResult(winningLottery);

        int profit = winningResult.calcProfit(lotteries);
        double ratio = user.calcRatio(profit);

        OutputView.printWinningStatistic(winningResult.getWinningStatistic());
        OutputView.printTotalRatio(ratio);
    }

    public WinningLottery createWinningLottery(String input) {
        List<LottoNumber> winningList = new ArrayList<>();
        String[] tokens = input.split(SEPARATOR);
        for (String token : tokens) {
            winningList.add(new LottoNumber(toInt(token.trim())));
        }
        return new WinningLottery(Lottery.createLottery(winningList));
    }

    public int toInt(String s) {
        return Integer.parseInt(s);
    }
}