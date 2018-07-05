package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int A_LOTTO_COUNT = 6;

    private List<Integer> numbers;
    private LottoState state;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        if (!isVaildLottoNumbers())
            throw new IllegalArgumentException("로또 번호가 잘못됐습니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setLottoState(Lotto winLotto) {
        int result = 0;
        for (int number : winLotto.getNumbers()) {
            if (numbers.contains(number))
                result++;
        }
        state = LottoState.valueOf(result);
    }

    public boolean isWinner(){
        return state.getMatchCount() >= LottoState.FORTH.getMatchCount();
    }

    public LottoState getLottoState() {
        return state;
    }

    public String buildLottoString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            result.append(", " + numbers.get(i));
        }
        result.append("]");
        return result.toString();
    }

    boolean isVaildLottoNumbers() {
        if (numbers == null)
            return false;

        if (Lotto.A_LOTTO_COUNT != numbers.size())
            return false;

        Set<Integer> overlapNumber = new HashSet<>();
        for (int number : numbers) {
            if (number < 1 || number > 45)
                return false;
            if (overlapNumber.contains(number))
                return false;

            overlapNumber.add(number);
        }
        return true;
    }
}
