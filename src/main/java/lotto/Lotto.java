package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final String DEFAULT_DELIMETER = ",";
    private List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public Lotto createSixNumbers() {
        pushFortyFive();        // 1~45 배열 만들기
        return getSixNumbers(); // 배열 섞기
    }

    private Lotto getSixNumbers() {
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);
        return this;
    }

    private void pushFortyFive() {
        for (int i = 0; i < 45; i++) {
            numbers.add(i + 1);
        }
    }

    public int matchBy(Lotto winnerLotto) {
        List<Integer> winnerNumbers = winnerLotto.getNumbers();
        int count = 0;
        for (Integer winnerNumber : winnerNumbers) {
            count = (numbers.contains(winnerNumber)) ? ++count : count;
        }
        return count;
    }

    public Lotto createWinLotto(String winNumbers) {
        String[] strs = getSplit(getTrim(winNumbers));
        for (String str : strs) {
            numbers.add(Integer.parseInt(getTrim(str)));
        }
        return this;
    }

    private String[] getSplit(String winNumbers) {
        return winNumbers.split(DEFAULT_DELIMETER);
    }

    private String getTrim(String winNumbers) {
        return winNumbers.trim();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
