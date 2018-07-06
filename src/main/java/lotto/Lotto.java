package lotto;

import java.util.*;

public class Lotto {
    public static final int LIMIT_WINCOUNT = 6;
    private Set<LottoNumber> numbers = new HashSet<>();

    public Lotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            this.numbers.add(new LottoNumber(number));
        }
        vaildNumber(numbers);
    }

    private void vaildNumber(List numbers) {
        if (numbers.size() != LIMIT_WINCOUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int containCount(WinningLotto target) {
        int count = 0;
        for (LottoNumber number : numbers) {
            count += target.contain(number);
        }
        return count;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        List<LottoNumber> list = new ArrayList<>(numbers);
        Collections.sort(list);
        return list + "";
    }
}
