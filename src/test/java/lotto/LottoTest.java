package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class LottoTest {
    List<Lotto> lottoes;
    Lotto singleLotto;
    @Before
    public void setUp(){
        LottoFactory lottoFactory = new LottoFactory();
        singleLotto = new Lotto();
    }
    @Test
    public void 로또구입금액딱맞음(){

        lottoes = lottoFactory.createLotto(5*1000);
        assertEquals(5, lottoes.size());
    }
    public void 로또구입금액잔액있음(){

        lottoes = lottoFactory.createLotto(5*1000);
        assertEquals(5, lottoes.size());
    }
    public void 로또구입금액음수(){

        lottoes = lottoFactory.createLotto(5*1000);
        assertEquals(5, lottoes.size());
    }
    public void 로또구입금액그냥돈없음(){

        lottoes = lottoFactory.createLotto(5*1000);
        assertEquals(5, lottoes.size());
    }
    @Test
    public void 번호자동생성(){
        singleLotto.generateNum();
    }
    @Test
    public void 번호정렬Collections(){
        singleLotto.sortNum();
    }
    @Test
    public void 입력로또번호검증성공케이스(){

    }
    @Test
    public void 입력로또번호중복(){

    }
    @Test
    public void 입력로또번호갯수안맞음(){

    }
    @Test
    public void 입력로또번호아님(){

    }
    @Test
    public void 당첨상황확인3개당첨(){
        assertEquals(3, compareNum(sucesses, origin));
    }
    @Test
    public void 당첨상황확인4개당첨(){
        assertEquals(4, compareNum(sucesses, origin));
    }
    @Test
    public void 당첨상황확인5개당첨(){
        assertEquals(5, compareNum(sucesses, origin));
    }
    @Test
    public void 당첨상황확인6개당첨(){
        assertEquals(6, compareNum(sucesses, origin));
    }
    @Test
    public void 당첨상황확미당첨(){
        assertTrue(3 > compareNum(sucesses, origin));
    }
    @Test
    public void 수익률계산() {
        assertEquals(exptected, calculateRate(lottoResults,money));
    }
}
