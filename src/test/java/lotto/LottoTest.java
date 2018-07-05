package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//Todo : todo

//Todo : done
// 1. 구입금액을 입력하면
// 2. 로또는 서로다른 45이하의 숫자를 6개의 숫자를 만든다. // 45개의 다른 숫자 담아주는 배열 , 6개를 추출하는 함수
// 3. 오름차순으로 정렬한다.
// 4. 생성된 로또 번호들을 출력해준다.
// 5. 당첨 번호를 입력해 주는 함수 만든다.
// 6. 한줄에 입력받은 값을 로또 객체로 반환해준다. + 6개이상의 숫자가 입력될 경우~로 확장

public class LottoTest {

    @Test
    public void getLottoSize() {
        Lotto lotto = new Lotto();
        assertEquals(6, lotto.getLottoSize());
    }

    @Test
    public void getLottoSizeWithCustom() {
        Lotto lotto = new Lotto(new String[] {"6", "5", "4", "3", "2", "1"});
        assertEquals(6, lotto.getLottoSize());
    }

    @Test
    public void sortAscendingOrder() {
        Lotto lotto = new Lotto();
        List testValues = new ArrayList<Integer>();
        testValues.add(2);
        testValues.add(1);

        assertEquals("[1, 2]", lotto.sortAscendingOrder(testValues).toString());
    }

    @Test
    public void hitLottoNumber() {
        Lotto lotto = new Lotto(new String[] {"6", "5", "4", "3", "2", "1"});
        Lotto winLotto = new Lotto(new String[] {"5", "4", "3", "2", "1", "6"});
        assertEquals(6, lotto.hitLottoNumber(winLotto));
    }
}