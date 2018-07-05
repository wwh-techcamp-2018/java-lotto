package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    public static List<Integer> createDistinctRandomNumList(int num) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            nums.add(getDistinctRandomNum(nums));
        }
        return nums;
    }

    public static int getDistinctRandomNum(List<Integer> nums) {
        int num;
        Random r = new Random();
        do {
            num = r.nextInt(100);
        } while (nums.contains(num));
        return num;
    }
}
