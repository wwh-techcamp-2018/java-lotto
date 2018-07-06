package lotto;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private Match match;
    private int count;

    public LottoResult(Match match) {
        this(match, 0);
    }

    public LottoResult(Match match, int count) {
        this.match = match;
        this.count = count;
    }

    public int calculateYield() {
        return match.calculateYield(count);
    }

    public void increment(List<Lotto> lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            if (isMatched(lotto.matchCountBy(winningLotto)))
                addCount();
        }
    }

    public boolean isMatched(int matchCount) {
        return match == Match.ofMatch(matchCount);
    }

    public void addCount() {
        this.count++;
    }

    public Match getMatch() {
        return match;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return count == that.count &&
                match == that.match;
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, count);
    }

}