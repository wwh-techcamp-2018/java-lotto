package lotto.generator;

import lotto.generator.FixLottoGenerator;
import lotto.resource.LottoNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void fixLottoTest() {
        FixLottoGenerator fixLotto = new FixLottoGenerator();
        LottoNumber[] result = fixLotto.generateNumber();
        assertThat(result).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }
}
