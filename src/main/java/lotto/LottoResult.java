package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final int MATCHED_COUNT = 7;
    private Map<Integer, Integer> result = new HashMap<>();

    public LottoResult() {
        for (int i = 0; i < MATCHED_COUNT; i++) {
            this.result.put(i, 0);
        }
    }

    public int getResult(int i) {
        return result.get(i);
    }

    public void makeResult(List<Lotto> list, WinningLotto winningLotto) {
        for (Lotto lotto : list) {
            result.put(matchedCount(lotto, winningLotto), result.get(matchedCount(lotto, winningLotto)) + 1);
        }
    }

    public static int matchedCount(Lotto lotto, WinningLotto winningLotto) {
        return lotto.containCount(winningLotto);
    }
}
