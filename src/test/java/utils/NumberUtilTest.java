package utils;

import lotto.resource.LottoNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {
    @Test
    public void split() {
        LottoNumber[] lottoNumbers = NumberUtil.splitString("1, 2, 3, 4, 5, 6");
        assertThat(lottoNumbers).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }
}
