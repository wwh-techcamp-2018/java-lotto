package lotto;

import lotto.generator.LottoGenerator;
import lotto.util.InputParser;

import java.util.*;

public class Lotto {

    private static final int PICK = 6;

    private Set<LottoNumber> lottoNumbers;

    public Lotto(LottoGenerator generator) {
        lottoNumbers = generator.generate();
    }

    public Lotto(String input) {
        List<String> tokens = InputParser.splitByComma(input);
        this.lottoNumbers = getLottoNumbers(tokens);
    }

    public static Set<LottoNumber> getLottoNumbers(List<String> tokens) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int i = 0; i < tokens.size(); i++) {
            lottoNumbers.add(new LottoNumber(tokens.get(i)));
        }

        if (lottoNumbers.size() != PICK) {
            throw new RuntimeException();
        }
        return lottoNumbers;
    }

    public int getCorrectCount(String winLotto) {
        int corrects = 0;
        List<String> tokens = InputParser.splitByComma(winLotto);
        for (LottoNumber number : getLottoNumbers(tokens)) {
            if (lottoNumbers.contains(number)) {
                corrects += 1;
            }
        }
        return corrects;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
