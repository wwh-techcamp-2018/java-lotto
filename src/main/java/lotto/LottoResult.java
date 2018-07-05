package lotto;

import java.util.Arrays;

public class LottoResult {
    private int[] resultnums;

    public LottoResult() {
        this.resultnums = new int[]{0, 0, 0, 0};
    }

    public LottoResult(int[] resultnums) {
        this.resultnums = resultnums;
    }

    public int[] addResult(int matches) {
        if (matches == 3)
            this.resultnums[0]++;
        if (matches == 4)
            this.resultnums[1]++;
        if (matches == 5)
            this.resultnums[2]++;
        if (matches == 6)
            this.resultnums[3]++;

        return getResult();
    }

    public int[] getResult() {
        return this.resultnums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Arrays.equals(resultnums, that.resultnums);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(resultnums);
    }
}
