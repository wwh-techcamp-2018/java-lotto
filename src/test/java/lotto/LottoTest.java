package lotto;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    //List<Lotto> lottoes;
    Lotto singleLotto;
    LottoFactory lottoFactory;

    @Before
    public void setUp() {
        lottoFactory = new LottoFactory();
        singleLotto = new Lotto();
    }

    @Test
    public void 로또갯수() {
        assertThat(LottoClient.maxLottoToBuy(new Money(5000))).isEqualTo(5);
    }

    @Test
    public void 로또구입금액딱맞음() {
        assertThat(LottoClient.maxLottoToBuy(new Money(5000))).isEqualTo(5);
//        lottoes = lottoFactory.createLotto(5*1000);
//        assertEquals(5, lottoes.size());
    }

    @Test
    public void 로또구입금액잔액있음() {
        assertThat(LottoClient.maxLottoToBuy(new Money(5300))).isEqualTo(5);
//        lottoes = lottoFactory.createLotto(5*1000+300);
//        assertEquals(5, lottoes.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또구입금액음수() {
        new Money(-100);
    }

    @Test
    public void 로또구입금액그냥돈없음() {
        assertThat(LottoClient.maxLottoToBuy(new Money(999))).isEqualTo(0);
    }

    @Test
    public void 번호자동생성갯수확인() {
        assertThat(LottoGenerator.generateNum()).hasSize(6);
    }

    @Test
    public void 입력로또번호검증성공케이스() {
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
        HitNumber hitNumbers = new HitNumber("1, 2, 3, 4, 5, 6");

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(Lotto.getLottoByInput(Arrays.asList(1, 2, 3, 11, 12, 13)).compareLotto(hitNumbers))
                .as("3개케이스").isEqualTo(3);
        assertions.assertThat(Lotto.getLottoByInput(Arrays.asList(1, 2, 3, 4, 12, 13)).compareLotto(hitNumbers))
                .as("4개케이스").isEqualTo(4);
        assertions.assertThat(Lotto.getLottoByInput(Arrays.asList(1, 2, 3, 4, 5, 13)).compareLotto(hitNumbers))
                .as("5개케이스").isEqualTo(5);
        assertions.assertThat(Lotto.getLottoByInput(Arrays.asList(1, 2, 3, 4, 5, 6)).compareLotto(hitNumbers))
                .as("6개케이스").isEqualTo(6);
        assertions.assertThat(Lotto.getLottoByInput(Arrays.asList(1, 2, 10, 11, 12, 13)).compareLotto(hitNumbers))
                .as("미당첨케이스").isLessThan(3);
        assertions.assertAll();
    }

    @Test
    public void 수익률계산() {
        double expected_1 = 250;
        double expected_2 = 35.7;
        Lotto nonHitLotto = Lotto.getLottoByInput(Arrays.asList(11, 12, 13, 14, 15, 16));
        Lotto thirdHitLotto = Lotto.getLottoByInput(Arrays.asList(1, 2 , 3, 14, 15, 16));
        HitNumber hitNumber = new HitNumber("1, 2, 3, 4, 5, 6");
        List<Lotto> lottoes1 = new ArrayList<Lotto>();
        List<Lotto> lottoes2 = new ArrayList<Lotto>();
        lottoes1.add(nonHitLotto);
        lottoes1.add(thirdHitLotto);
        for(int i = 0 ; i < 13 ; i++){
            lottoes2.add(nonHitLotto);
        }
        lottoes2.add(thirdHitLotto);
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(LottoClient.calculateBenefitRate(lottoes1, hitNumber))
                .as("2개 중 3 등 하나")
                .isEqualTo(expected_1);

        assertions.assertThat(LottoClient.calculateBenefitRate(lottoes2,hitNumber))
                .as("14개 중 3 등 하나")
                .isEqualTo(expected_2);

        assertions.assertAll();
    }
}
