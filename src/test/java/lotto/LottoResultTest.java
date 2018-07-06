package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class LottoResultTest {

    LottoResult lottoResult;

    @Before
    public void setUp() throws Exception {
        lottoResult = new LottoResult();
    }


    @Test
    public void addResult() {
        int[] keys = new int[]{3, 4, 5, 6};
        lottoResult.getResult().get(3);
        assertThat(lottoResult.getResult()).contains(entry(3, 0), entry(4, 0), entry(5, 0), entry(6, 0));
        lottoResult.addResult(1);
        assertThat(lottoResult.getResult()).contains(entry(3, 0), entry(4, 0), entry(5, 0), entry(6, 0));
        lottoResult.addResult(3);
        assertThat(lottoResult.getResult()).contains(entry(3, 1), entry(4, 0), entry(5, 0), entry(6, 0));
        lottoResult.addResult(6);
        assertThat(lottoResult.getResult()).contains(entry(3, 1), entry(4, 0), entry(5, 0), entry(6, 1));
        lottoResult.addResult(6);
        assertThat(lottoResult.getResult()).contains(entry(3, 1), entry(4, 0), entry(5, 0), entry(6, 2));
    }

}