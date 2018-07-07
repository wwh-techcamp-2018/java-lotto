package lottery;

import java.util.Arrays;
import java.util.List;

public class WinningResult {

    private final static int NUM = 4;

    public final static int MIN_MATCHING = 3;
    public final static int MAX_MATCHING = 6;

    private int[] result;
    private WinningLottery winningLottery;

    public WinningResult(WinningLottery winningLottery) {
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
        for (Rank rank : Rank.values()) {
            sum += result[rank.getMatchingCount() - MIN_MATCHING] * rank.getProfit();
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

    public String getWinningStatistic() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            sb.append(rank.getMatchingCount()+"개 일치 ("+rank.getProfit()+")");
            sb.append("- "+result[rank.getMatchingCount() - WinningResult.MIN_MATCHING]);
            sb.append("\n");
        }
        return sb.toString();
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
