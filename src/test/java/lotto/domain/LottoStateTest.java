package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoStateTest {

    @Test
    public void valueofTest(){
        assertEquals(LottoState.FORTH, LottoState.valueOf(3));
        assertEquals(LottoState.THIRD, LottoState.valueOf(4));
        assertEquals(LottoState.SECOND, LottoState.valueOf(5));
        assertEquals(LottoState.FIRST, LottoState.valueOf(6));
        assertEquals(LottoState.FAIL, LottoState.valueOf(2));

    }

}