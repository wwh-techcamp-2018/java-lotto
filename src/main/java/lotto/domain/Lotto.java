package lotto.domain;

import lotto.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private LottoNo[] lottoNumbers;

    public Lotto(LottoNo... lottoNumbers) {
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static List<Lotto> of(String... lottoNumberStrings) {
        return Stream.of(lottoNumberStrings).map(StringUtil::parseToLotto).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Arrays.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lottoNumbers);
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers);
    }

    public int countIntersection(LottoResult lottoResult) {
        return (int) Arrays.stream(lottoNumbers).filter(lottoResult::containsNumber).count();
    }

    public boolean contains(LottoNo number) {
        return Stream.of(lottoNumbers)
                .anyMatch(lottoNo -> lottoNo.equals(number));
    }

    public boolean hasBonusBall(LottoResult lottoResult) {
        return lottoResult.containsBonusNumber(lottoNumbers);
    }
}
