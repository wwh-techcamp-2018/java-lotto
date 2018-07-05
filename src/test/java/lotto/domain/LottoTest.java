package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void createLottoNullExceptionTest() {
        new Lotto(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createLottoOutboundExceptionTest() {
        new Lotto(new ArrayList<>());
    }

    @Test
    public void matchNumberTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lotto.setLottoState(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        assertEquals(3, lotto.getLottoState().getMatchCount());
    }

    @Test
    public void buildLottoStringTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected, lotto.buildLottoString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자개수_불일치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자범위_불일치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 60));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자중복_체크() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
    }


}