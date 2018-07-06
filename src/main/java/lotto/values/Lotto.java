package lotto.values;

import lotto.LottoNumberGenerator;
import lotto.StringParser;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private  Set<LottoNumber> lottoNumbers;

    public Lotto(String string) {
        this(StringParser.parse(string));
    }

    public Lotto(List<Integer> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Lotto() {
        this(LottoNumberGenerator.generateNumbers());
    }


    public Rank match(Lotto lotto) {
        return Rank.valueOf((int) this.lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count());
    }

    public String toString() {
        List<Integer> lottoNumbersList = lottoNumbers.stream().map(LottoNumber::toInt).collect(Collectors.toList());
        Collections.sort(lottoNumbersList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Integer lottoNumber : lottoNumbersList) {
            stringBuilder.append(lottoNumber.toString())
            .append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
