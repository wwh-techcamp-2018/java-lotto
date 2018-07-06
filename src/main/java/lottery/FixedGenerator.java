package lottery;

import static lottery.LottoNumber.LOTTO_LENGTH;

public class FixedGenerator implements NumberGenerator {
    private int[] numbers;
    private int index = 0;

    public FixedGenerator(int... numbers) {
        if (numbers.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    @Override
    public LottoNumber generate() {
        int ret = numbers[index];
        index = (index + 1) % LOTTO_LENGTH;
        return new LottoNumber(ret);
    }
}