package lotto.values;

import lotto.LottoNumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        Collections.sort(numbers);

        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto() {
        this(LottoNumberGenerator.generateNumbers());
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> appeared = new HashSet<>(numbers);
        if (appeared.size() < numbers.size()) {
            return true;
        }
        return false;
    }

    public int match(Lotto lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.toString())
            .append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
