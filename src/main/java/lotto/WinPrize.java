package lotto;

public enum WinPrize {
    _3(5000), _4(50000), _5(1500000), _6(2000000000);

    private final int value;

    WinPrize(int prize) {
        this.value = prize;
    }

    public static Integer getPrize(Integer i) {
        return valueOf("_" + i).value;
    }
}
