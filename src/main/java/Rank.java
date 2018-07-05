public class Rank {
    public static final int LOSER_RANK = -1;
    private static final int LOSER_THRESHOLD = 3;

    public static int getRank(int matchCount) {
        if (matchCount < LOSER_THRESHOLD)
            return LOSER_RANK;
        return 7 - matchCount;
    }

    public static int getRankPrize(int rankNumber) {
        if(rankNumber == 4)
            return PrizeMoney.FOURTH.getPrize();
        if(rankNumber == 3)
            return PrizeMoney.THIRD.getPrize();
        if(rankNumber == 2)
            return PrizeMoney.SECOND.getPrize();
        if(rankNumber == 1)
            return PrizeMoney.FIRST.getPrize();
        return PrizeMoney.LOSER.getPrize();
    }

    public static int getMatchingPrize(int matchCount) {
        return getRankPrize(getRank(matchCount));
    }
}
