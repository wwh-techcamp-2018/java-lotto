package lotto.util;

import lotto.domain.LottoNo;
import lotto.domain.LottoResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @Test
    public void parseString() {
        LottoResult lottoResult = StringUtil.parseToLottoResult("1, 2, 3, 4, 5 ,6");
        assertThat(lottoResult.containsNumber(LottoNo.of(1)))
                .isTrue();
    }
}
