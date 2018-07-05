package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//TODO : TODO

//TODO : DONE
// 금액에 해당하는 로또를 생성한다.
// 전체 로또를 출력해준다
// 내 로또랑 당첨 로또랑 비교해주는 함수.(return 몇개가 일치되었는지)
// 당첨 통계를 출력해준다.
// 수익률을 출력해준다.

public class LottoFactoryTest {

    @Test
    public void buyLotto() {
        LottoContainer lottoContainer = new LottoContainer(12);
        assertEquals(12, lottoContainer.countLotto());
    }

    @Test
    public void printLottoList() {
        List<Lotto> tempLotto = new ArrayList<>();
        tempLotto.add(new Lotto(new String[] {"6", "5", "4", "3", "2", "1"}));

        LottoContainer tempLottoContainer = new LottoContainer(tempLotto);
        assertEquals("[1, 2, 3, 4, 5, 6]", tempLottoContainer.toString());

    }

}