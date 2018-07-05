package lotto;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    List<Lotto> lottoes;
    Lotto singleLotto;
    LottoFactory lottoFactory;

    @Before
    public void setUp(){
        lottoFactory = new LottoFactory();
        singleLotto = new Lotto();
    }
    @Test
    public void 로또갯수(){
        assertThat(lottoFactory.maxLottoToBuy(5*1000)).isEqualTo(5);
    }
    @Test
    public void 로또구입금액딱맞음(){

        lottoes = lottoFactory.createLotto(5*1000);
        assertEquals(5, lottoes.size());
    }
    @Test
    public void 로또구입금액잔액있음(){

        lottoes = lottoFactory.createLotto(5*1000+300);
        assertEquals(5, lottoes.size());
    }
    @Test
    public void 로또구입금액음수(){

        lottoes = lottoFactory.createLotto(-10);
        assertEquals(0, lottoes.size());
    }
    @Test
    public void 로또구입금액그냥돈없음(){
        lottoes = lottoFactory.createLotto(10);
        assertEquals(0, lottoes.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void 음수금액입력(){
        new Money(-100);
    }
    @Test
    public void 번호자동생성갯수확인(){
        assertThat(LottoGenerator.generateNum()).hasSize(6);
    }
    @Test
    public void 입력로또번호검증성공케이스(){
        final String expectedInput = "1, 2, 3, 4, 5, 6";
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(HitNumber.isValid(expectedInput))
                .as("정상 케이스").isTrue();
        assertions.assertThat(HitNumber.isValid("1, 2, 3, 4, 5, 0"))
                .as("1보다 작은 애").isFalse();
        assertions.assertThat(HitNumber.isValid("1, 2, 3, 4, 5, 46"))
                .as("45 넘는 애").isFalse();
        assertions.assertThat(HitNumber.isValid("1, 2, 3"))
                .as("숫자 여섯 개 아닐 떄").isFalse();
        assertions.assertThat(HitNumber.isValid("1, b, 3, 4, 5, 6"))
                .as("숫자 자리에 문자일 때").isFalse();
        assertions.assertAll();
    }
    @Test
    public void 당첨상황확인() {
        HitNumber hitMaker = new HitNumber("1, 2, 3, 4, 5, 6");
        List<Integer> hitNumbers = hitMaker.getNumbers();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(Lotto.compareNumList(Arrays.asList(1,2,3,11,12,13), hitNumbers))
                .as("3개케이스").isEqualTo(3);
        assertions.assertThat(Lotto.compareNumList(Arrays.asList(1,2,3,4,11,12), hitNumbers))
                .as("4개케이스").isEqualTo(4);
        assertions.assertThat(Lotto.compareNumList(Arrays.asList(1,2,3,4,5,11), hitNumbers))
                .as("5개케이스").isEqualTo(5);
        assertions.assertThat(Lotto.compareNumList(Arrays.asList(1,2,3,4,5,6), hitNumbers))
                .as("6개케이스").isEqualTo(6);
        assertions.assertThat(Lotto.compareNumList(Arrays.asList(1,2,13,14,15,16), hitNumbers))
                .as("미당첨케이스").isLessThan(3);
        assertions.assertAll();
    }

    @Test
    public void 수익률계산() {
        double expected_1 = 250;
        double expected_2 = 35.7;
        List<Integer> target_1 = Arrays.asList(3, 0);
        Integer[] arr_target_2 = new Integer[14];
        for(int i=0;i<arr_target_2.length;i++){
            arr_target_2[i] = 0;
        }
        arr_target_2[0] = 3;
        List<Integer> target_2 = Arrays.asList(arr_target_2);

        SoftAssertions assertions = new SoftAssertions();


        assertions.assertThat(A.calculateTemplate(target_1))
                .as("2개 중 3 등 하나")
                .isEqualTo(expected_1);

        assertions.assertThat(A.calculateTemplate(target_2))
                .as("14개 중 3 등 하나")
                .isEqualTo(expected_2);

        assertions.assertAll();
    }
}
