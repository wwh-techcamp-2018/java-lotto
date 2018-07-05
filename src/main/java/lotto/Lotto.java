package lotto;

import lotto.resource.LottoNumber;
import lotto.resource.Positive;

import java.util.*;

public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(LottoNumber[] lotto) {
        if (lotto.length != 6) {
            throw new IllegalArgumentException();
        }
        this.lotto = Arrays.asList(lotto);
        Collections.sort(this.lotto);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public Positive getEqualNumber(Lotto winningLotto) {
        int count = 0;
        for (int i = 0; i < this.lotto.size(); i++) {
            count += isContains(winningLotto.getLotto().get(i));
        }
        return new Positive(count);
    }

    private int isContains(LottoNumber lottoNumber) {
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
