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
        Integer[] a = {1, 2, 3, 6, 5, 4};
        LottoNumber[] lis = new LottoNumber[6];
        for (int i = 0; i < lis.length; i++) {
            lis[i] = new LottoNumber(a[i]);
        }
        Lotto l = new Lotto(lis);

        assertThat(l.getLotto()).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}



