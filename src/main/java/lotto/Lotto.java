package lotto;

import lotto.resource.LottoNumber;
import utils.NumberUtil;

import java.util.*;

public class Lotto {
    public static final Integer LOTTO_NUMBER = 6;

    private List<LottoNumber> lotto;

    private Lotto(LottoNumber[] lotto) {
        this.lotto = Arrays.asList(lotto);
        Set<LottoNumber> lottoSet = new HashSet<LottoNumber>(this.lotto);
        if(lottoSet.size() != LOTTO_NUMBER){
            throw new IllegalArgumentException();
        }
        Collections.sort(this.lotto);
    }

    public static Lotto ofComma(String inputString) {
        return new Lotto(NumberUtil.splitString(inputString));
    }

    public static Lotto ofNumbers(Integer... inputNumbers) {
        if(inputNumbers.length != LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        LottoNumber[] lottoNumbers = new LottoNumber[inputNumbers.length];
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = LottoNumber.of(inputNumbers[i]);
        }
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofLottoNumbers(LottoNumber[] lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofAuto() {
        return Lotto.ofNumbers(pullSixNumbers(shuffle()));
    }

    private static Integer[] pullSixNumbers(List<Integer> numbers) {
        Integer[] randomNumbers = new Integer[LOTTO_NUMBER];
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            randomNumbers[i] = numbers.get(i);
        }
        return randomNumbers;
    }

    private static List<Integer> shuffle() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= LottoNumber.LOTTO_MAX_VALUE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public int getEqualNumber(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += winningLotto.increment(lottoNumber);
        }
        return count;
    }

    private int increment(LottoNumber lottoNumber) {
        if (this.lotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lotto.size() - 1; i++) {
            sb.append(lotto.get(i).getLottoNumber() + ", ");
        }
        sb.append(lotto.get(lotto.size() - 1).getLottoNumber() + "]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotto);
    }
}
