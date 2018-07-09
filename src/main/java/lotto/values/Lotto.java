package lotto.values;

import lotto.LottoNumberGenerator;
import lotto.StringParser;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Lotto(String string) {
        this(StringParser.parse(string));
    }

    public Lotto(List<Integer> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto() {
        this(LottoNumberGenerator.generateNumbers());
    }

    public static List<Lotto> ofStringList(List<String> stringList) {
        return stringList.stream()
                .map(StringParser::parse)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public int match(Lotto lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    public String toString() {
        return lottoNumbersToSortedList(this.lottoNumbers).toString();
    }

    private static List<Integer> lottoNumbersToSortedList(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::toInt)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }


    public boolean hasNumber(int bonusNumber) {
        return lottoNumbers.contains(new LottoNumber(bonusNumber));
    }
}
