package lottery;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WinningResultTest {
    private WinningResult winningResult;

    @Before
    public void setUp() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        winningResult = new WinningResult(new WinningLottery(Lottery.createLottery(lottoNumbers)));
    }

    @Test
    public void isValidNumOfMathcing() {
        assertEquals(true, winningResult.isValidNumOfMathcing(4));
        assertEquals(false, winningResult.isValidNumOfMathcing(2));
        assertEquals(false, winningResult.isValidNumOfMathcing(7));
    }

    @Test
    public void calProfit() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        int actual = winningResult.calcProfit(Arrays.asList(Lottery.createLottery(lottoNumbers)));
        assertEquals(2000000000, actual);
    }
}