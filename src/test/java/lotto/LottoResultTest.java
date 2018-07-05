package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.*;


public class LottoResultTest {

    LottoResult lottoResult;

    @Before
    public void setUp() throws Exception {
        lottoResult = new LottoResult();
    }

    @Test
    public void addResult() {
        lottoResult.addResult(1);
        assertThat(lottoResult.getResult()).isEqualTo(new int[] {0,0,0,0});
        lottoResult.addResult(3);
        assertThat(lottoResult.getResult()).isEqualTo(new int[] {1,0,0,0});
        lottoResult.addResult(6);
        assertThat(lottoResult.getResult()).isEqualTo(new int[] {1,0,0,1});
        lottoResult.addResult(6);
        assertThat(lottoResult.getResult()).isEqualTo(new int[] {1,0,0,2});
    }

}