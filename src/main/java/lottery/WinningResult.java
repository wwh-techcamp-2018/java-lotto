package lottery;

import java.util.Arrays;
import java.util.List;

public class WinningResult {

    // 4 : 3, 4, 5, 6
    private final static int NUM = 4;
    private final static int MIN_MATCHING = 3;
    private final static int MAX_MATCHING = 6;
    private final static int[] PRIZE_MONEYS = {5000, 50000, 1500000, 2000000000};

    private int[] result;
    private List<Integer> winningLottery;

    public WinningResult(List<Integer> winningLottery) {
        result = new int[NUM];
        this.winningLottery = winningLottery;
    }

    public int calcProfit(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            count(lottery);
        }
        return calcProfit();
    }

    private int calcProfit() {
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i] * PRIZE_MONEYS[i];
        }
        return sum;
    }

    private void count(Lottery lottery) {
        int numOfMatching = lottery.getNumOfMatching(winningLottery);
        if (isValidNumOfMathcing(numOfMatching))
            result[numOfMatching - MIN_MATCHING]++;
    }

    public boolean isValidNumOfMathcing(int numOfMatching) {
        if (numOfMatching < MIN_MATCHING) return false;
        if (numOfMatching > MAX_MATCHING) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult that = (WinningResult) o;
        return Arrays.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(result);
    }
}
