package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int A_LOTTO_COUNT = 6;

    private Set <Integer> numbers;
    private LottoState state;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
        if (!isValidLottoNumbers())
            throw new IllegalArgumentException("로또 번호가 잘못됐습니다.");

    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void matchState(Lotto winLotto) {
        int result = 0;
        result = winLotto.getNumbers().stream()
                .filter(number -> numbers.contains(number))
                .collect(Collectors.toList()).size();
        state = LottoState.valueOf(result);
    }

    public boolean isWinner(){
        return state.isWinner();
    }

    public LottoState getLottoState() {
        return state;
    }

    public String buildLottoString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Integer number : numbers) {
            result.append(number + ", ");
        }
        return result.substring(0, result.length() -2) + "]";
    }

    boolean isValidLottoNumbers() {

        if(!isValidSize())
            return false;
        if(!isValidBoundary())
            return false;

        return true;
    }

    private boolean isValidSize() {
        if (numbers == null)
            throw new IllegalArgumentException();

        if (Lotto.A_LOTTO_COUNT != numbers.size())
            return false;
        return true;
    }

    private boolean isValidBoundary() {
        for (int number : numbers) {
            if (number < 1 || number > 45)
                return false;
        }
        return true;
    }


}
