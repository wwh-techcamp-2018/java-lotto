package lottery;

import dto.ResultDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoughtLottoListTest {

    @Test
    public void toResultDto() {
        BoughtLottoList lottoList = new BoughtLottoList();
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto lotto3 = new Lotto(1, 2, 3, 4, 5, 6);

        lotto.draw();
        lotto2.draw();
        lotto3.draw();

        lottoList.add(lotto);
        lottoList.add(lotto2);
        lottoList.add(lotto3);

        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"));
        winningLotto.draw();

        ResultDto ratio = lottoList.toResultDto(winningLotto, new Balance(3000));
        assertThat(ratio.getEarningRate().toFloat()).isEqualTo(200000);
    }
}