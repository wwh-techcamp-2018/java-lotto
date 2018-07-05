package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPlayTest {
    @Test
    public void 금액으로부터갯수반환() {
        assertThat(LottoPlay.getLottoCount(14500)).isEqualTo(14);
    }

    @Test
    public void 번호가6개인_로또생성() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).getNumbers().size()).isEqualTo(6);
    }

    @Test(expected = Exception.class)
    public void 번호가5개인_로또생성() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5)).getNumbers().size()).isEqualTo(5);
    }

    @Test
    public void 팩토리에서_로또생성() {
        assertThat(new LottoFactory(new LottoGenerator()).makeLottos(3).size()).isEqualTo(3);
    }

    @Test
    public void 로또몇개맞았니() {
        assertThat(LottoResult.matchedCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(5);
    }

    @Test
    public void 로또_당첨통계_2개() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 3, 2, 10, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 4, 2, 5, 6, 8));
        List<Lotto> list = Arrays.asList(lotto1, lotto2, lotto3);
        lottoResult.makeResult(list, Arrays.asList(1, 2, 3, 10, 11, 12));
        assertThat(lottoResult.getResult(2)).isEqualTo(1);
    }
}
