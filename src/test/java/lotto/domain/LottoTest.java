package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void createLottoNullExceptionTest() {
        new Lotto(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createLottoOutboundExceptionTest() {
        new Lotto(Sets.newHashSet(new ArrayList<>()));
    }

    @Test
    public void matchNumberTest() {
        Lotto lotto = Lotto.valueOf(1, 2, 3, 4, 5, 6);

        assertEquals(3, lotto.getMatchCount(Lotto.valueOf(1, 2, 3, 7, 8, 9)));
    }

    @Test
    public void buildLottoStringTest() {
        Lotto lotto = Lotto.valueOf(1, 2, 3, 4, 5, 6);
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected, lotto.buildLottoString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자개수_불일치() {
        Lotto lotto = Lotto.valueOf(1, 2, 3, 4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자중복_체크() {
        Lotto lotto = Lotto.valueOf(1, 2, 3, 4, 5, 5);
    }

    @Test
    public void valueOfTest() {
        Lotto lotto = Lotto.valueOf(1, 2, 3, 4, 5, 6);
        int value = 1;
        for (LottoNo lottoNo : lotto.getNumbers()) {
            assertEquals(value, lottoNo.getNumber());
            value++;
        }
    }


}