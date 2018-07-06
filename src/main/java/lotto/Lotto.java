package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public static List<Integer> settingNumbers;

    static {
        settingNumbers = IntStream.range(1, 46).mapToObj(i -> i).collect(Collectors.toList());
    }

    private List<Integer> lottoNumbers = settingNumbers;

    public Lotto() {
        makeLotto();
    }

    public Lotto(String[] numbers) {
        this.lottoNumbers = sortAscendingOrder(Arrays.stream(numbers)
                .map(i -> i.trim())
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList()));
    }

    public void makeLotto() {
        this.lottoNumbers = sortAscendingOrder(selectSixNumbers(shuffleNumbers()));
    }

    public int getLottoSize() {
        return this.lottoNumbers.size();
    }

    public List shuffleNumbers() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    public List selectSixNumbers(List<Integer> candidates) {
        return candidates.stream().limit(LOTTO_SIZE).collect(Collectors.toList());
    }

    public List sortAscendingOrder(List numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int hitLottoNumber(Lotto winLotto) {
        winLotto.getLottoNumbers().retainAll(this.lottoNumbers);
        return winLotto.getLottoNumbers().size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
