package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void getLottoNumbers() {
        Set<LottoNumber> lottoNumbers = Lotto.getLottoNumbers(Arrays.asList("1","2","3","4","5","6"));
        assertThat(lottoNumbers)
                .contains(new LottoNumber(1))
                .contains(new LottoNumber(2))
                .contains(new LottoNumber(3))
                .contains(new LottoNumber(4))
                .contains(new LottoNumber(5))
                .contains(new LottoNumber(6));
    }

    @Test
    public void getCorrectCount() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int count = lotto.getCorrectCount("1,2,3,11,12,13");
        assertThat(count).isEqualTo(3);
    }

}
