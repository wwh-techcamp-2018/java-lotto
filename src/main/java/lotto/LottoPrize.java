package lotto;

public class LottoPrize implements Comparable<LottoPrize> {

    public static final int CORRECT_TYPES = 7;

    private static final int[] PRIZE = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private int correctNum;

    public LottoPrize(int correctNum) {
        this.correctNum = correctNum;
    }

    public int getPrize() {
        return PRIZE[correctNum];
    }

    @Override
    public String toString() {
        return correctNum + "개 일치(" + getPrize() + "원)";
    }

    @Override
    public int compareTo(LottoPrize other) {
        if (other.getPrize() < this.getPrize()) {
            return 1;
        }
        if (other.getPrize() == this.getPrize()) {
            return 0;
        }
        if (other.getPrize() > this.getPrize()) {
            return -1;
        }
        return 0;
    }
}
