package lottery;

import java.util.Objects;

public class WinningLottery {
    private Lottery lottery;

    public WinningLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public Lottery getLottery() {
        return lottery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottery that = (WinningLottery) o;
        return Objects.equals(lottery, that.lottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery);
    }
}
