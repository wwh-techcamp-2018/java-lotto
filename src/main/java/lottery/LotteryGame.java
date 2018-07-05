package lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteryGame {
    private static final String COMMA = ",";

    public List<Integer> createWinningLottery(String input) {
        List<Integer> winningList = new ArrayList<>();
        String[] tokens = input.split(COMMA);

        for (String token : tokens) {
            winningList.add(toInt(token));
        }

        return winningList;
    }

    public int toInt(String s) {
        return Integer.parseInt(s);
    }

    public void run() {
        User user = new User(14000);

        List<Lottery> lotteries = user.buyLottery();

        List<Integer> winningLottery = createWinningLottery("1,2,3,4,5,6");

        WinningResult result = new WinningResult(winningLottery);
        int profit = result.calcProfit(lotteries);
        int ratio = user.calcRatio(profit);
        // print(ratio)
    }


    // woo
    public void main() {
        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame.run();
    }


}
