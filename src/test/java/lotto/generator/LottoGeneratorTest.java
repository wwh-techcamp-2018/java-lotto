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
        assertThat(result).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}
