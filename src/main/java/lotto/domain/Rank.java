package lotto.domain;

public enum Rank {

    FAIL(0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    public static final int WIN_MAX = 7;
    public static final int WIN_MIN = 3;

    private static final Rank[] ranks = {FAIL, SIXTH, FIFTH, FOURTH, THIRD, SECOND, FIRST};

    private final int match;
    private final int prize;

    Rank(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public static int prizeOf(int match) {
        return Rank.values()[match].prize;
    }

    public static Rank of(int match) {
        return ranks[match];
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", match, prize);
    }

}
