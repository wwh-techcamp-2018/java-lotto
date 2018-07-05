package lotto;

public enum PrizeData {

    _3(5000),
    _4(50000),
    _5(1500000),
    _6(2000000000);

    private int prizeMoney;

    PrizeData(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
