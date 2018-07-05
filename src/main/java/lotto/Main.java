package lotto;

import lotto.util.stringUtil;

public class Main {

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        int money = InputView.askBudget();
        ResultView.printTickets(game.buyTicket(money, new RandomValueGenerator()));
        LottoResult result = game.matchTickets(stringUtil.toIntList(InputView.askWinningNums()));
        ResultView.printStatistics(result);
        ResultView.printRevenue(game.calculateRevenue(money, result));
    }
}
