package lottery;

import java.util.List;
import java.util.Objects;

public class Lottery {

    public final static int COUNT_NUM = 6;
    public final static int PRICE = 1000;

    private List<Integer> nums;

    public Lottery(List<Integer> nums) {
        this.nums = nums;
    }

    public int getNumOfMatching(List<Integer> winningLottery) {
        long numOfMatching = winningLottery.stream()
                .filter(winningNum -> nums.contains(winningNum))
                .count();
        return (int) numOfMatching;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(nums, lottery.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int num : nums) {
            sb.append(num);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}

