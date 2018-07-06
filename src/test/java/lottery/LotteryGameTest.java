package lottery;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LotteryGameTest {

    private LotteryGame lotteryGame;

    @Before
    public void setUp() throws Exception {
        lotteryGame = new LotteryGame();
    }

    @Test
    public void createWinningLottery() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        assertEquals(new WinningLottery(Lottery.createLottery(lottoNumbers)), lotteryGame.createWinningLottery("1,2,3,4,5,6"));
    }


}