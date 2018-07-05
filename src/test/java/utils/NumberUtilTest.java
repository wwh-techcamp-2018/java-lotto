package utils;

import lotto.resource.LottoNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {
    @Test
    public void split() {
        LottoNumber[] lottoNumbers = NumberUtil.splitString("1, 2, 3, 4, 5, 6");
        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}
