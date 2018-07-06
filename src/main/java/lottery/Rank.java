package lottery;

public enum Rank {
    FIRST(6, 2_000_000_000),
    //    SECOND(6, ),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    KKWANG(0, 0);

    private int numMatched;
    private int prize;

    Rank(int numMatched, int prize) {
        this.numMatched = numMatched;
        this.prize = prize;
    }

    static Rank matchScore(int numMatched) {
        Rank ret = KKWANG;
        for (Rank rank : Rank.values()) {
            ret = rank.match(numMatched, ret);
        }
        return ret;
    }

    private Rank match(int numMatched, Rank rank) {
        if (this.numMatched == numMatched) {
            rank = this;
        }
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getNumMatched() {
        return numMatched;
    }
}
