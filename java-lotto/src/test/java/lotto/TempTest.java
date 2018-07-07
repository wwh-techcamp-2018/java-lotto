package lotto;

import lotto.resource.LottoNumber;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TempTest {
    @Test
    public void aa() {
        Integer[] a = {1, 2, 3, 4, 5};
        List<Integer> li = Arrays.asList(a);
        Collections.shuffle(li);
    }

    @Test
    public void aaa() {
        Lotto l = Lotto.ofNumbers(1, 2, 3, 6, 5, 4);

        assertThat(l.getLotto()).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }
}