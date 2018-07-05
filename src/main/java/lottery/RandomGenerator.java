package lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lottery.LottoNumber.MAX_LOTTO_NUMBER;
import static lottery.LottoNumber.MIN_LOTTO_NUMBER;

public class RandomGenerator implements NumberGenerator {
    Random random = new Random();
    List<Integer> numbers = new ArrayList<Integer>();

    public RandomGenerator() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
    }

    @Override
    public LottoNumber generate() {
        return new LottoNumber(numbers.remove(random.nextInt(numbers.size() - 1)));
    }


}
