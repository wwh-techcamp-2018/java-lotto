package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// TODO 질문
public class Lotto {
    private static final String DEFAULT_DELIMITER = ",";
    private List<LottoNumber> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        numbers = getSixNumbers(shuffle(pushFortyFive()));
    }

    public Lotto(String inputNumbers) {
        numbers = new ArrayList<>();
        String[] strs = getSplit(getTrim(inputNumbers));
        for (String str : strs) {
            numbers.add(new LottoNumber(Integer.parseInt(getTrim(str))));
        }
    }

    public static Lotto ofBlank() {
        return new Lotto();
    }

    public static Lotto ofString(String numbers) {
        return new Lotto(numbers);
    }

    private List<LottoNumber> getSixNumbers(List<LottoNumber> numbers) {
        return numbers.subList(0, 6);
    }

    private List<LottoNumber> shuffle(List<LottoNumber> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<LottoNumber> pushFortyFive() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    // 로또 메소드
    public int getMatchCount(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber number : numbers) {
            count += winningLotto.increment(number);
        }
        return count;
    }

    // 당첨로또 메소드
    private int increment(LottoNumber number) {
        return numbers.contains(number) ? 1 : 0;
    }

    private String[] getSplit(String inputNumbers) {
        return inputNumbers.split(DEFAULT_DELIMITER);
    }

    private String getTrim(String inputNumbers) {
        return inputNumbers.trim();
    }


    public List<LottoNumber> getNumbers() {
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
