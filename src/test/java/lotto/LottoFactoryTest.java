package lotto;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LottoFactoryTest {

    @Test
    public void createLotto() {
        List<Lotto> lottos = LottoFactory.create(14);
        assertEquals(14, lottos.size());
    }
}
