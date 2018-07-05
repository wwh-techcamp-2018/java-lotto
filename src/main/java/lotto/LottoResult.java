package lotto;

import java.util.List;

public class LottoResult {
    private final int MATCHED_COUNT = 7;
    int[] result = new int[MATCHED_COUNT];

    public static int matchedCount(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            count += isMatched(lotto, winningNumbers.get(i));
        }
        return count;
    }

    public static int isMatched(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            return 1;
        }
        return 0;
    }

    public int getResult(int i) {
        return result[i];
    }

    public int[] getResult() {
        return result;
    }

    public void makeResult(List<Lotto> list, List<Integer> integers) {
        for (Lotto lotto : list) {
            result[matchedCount(lotto, integers)]++;
        }
    }
}
