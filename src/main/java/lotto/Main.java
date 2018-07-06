package lotto;

import lotto.util.StringUtil;

public class Main {

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        int money = InputView.askBudget();
        ResultView.printTickets(game.buyTicket(money, new RandomValueGenerator()));
        WinningTicket winningTicket = new WinningTicket(LottoNumber.listOf(StringUtil.toIntList(InputView.askWinningNums())));
        LottoResult result = game.matchTickets(winningTicket);
        ResultView.printStatistics(result);
        ResultView.printRevenue(game.calculateRevenue(money, result));
    }
}
