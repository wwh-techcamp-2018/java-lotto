public enum PrizeMoney {

    LOSER(0),
    FOURTH(5000),
    THIRD(50000),
    SECOND(1500000),
    FIRST(2000000000);

    private final int value;

    PrizeMoney(final int value) {
        this.value = value;
    }

    public int getPrize() {
        return this.value;
    }
}