package lotto;

import java.util.Map;

public class Play {
    public static void main(String[] args) {

        Integer money = InputView.getMoney();
        Game g = new Game(money);
        ResultView.printLottos(g.getLottos());

        Map<Integer, Integer> map = g.match(InputView.getWinsNumber());
        ResultView.printStatistics(map);

        int revenue = map.entrySet().stream()
                .mapToInt(e -> e.getValue() * WinPrize.getPrize(e.getKey()))
                .sum();

        ResultView.printProfit(revenue, money);

    }
}
