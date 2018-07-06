package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LottoStatisticsTest {

    private LottoStatistics statisticsTest;

    @Before
    public void setUp() throws Exception {
        List<Lotto> tempLotto = new ArrayList<>();
        tempLotto.add(new Lotto(new String[] {"6", "5", "4", "3", "2", "1"}));
        tempLotto.add(new Lotto(new String[] {"7", "5", "4", "3", "2", "1"}));
        tempLotto.add(new Lotto(new String[] {"8", "5", "4", "3", "2", "1"}));
        LottoContainer tempLottoContainer = new LottoContainer(tempLotto);

        statisticsTest = new LottoStatistics(tempLottoContainer);
    }

    @Test
    public void doStatistics() {
        Map map = statisticsTest.doStatistics(new Lotto(new String[]{"6", "5", "4", "3", "2", "1"}));
        assertEquals(2, map.get(PrizeData.SECOND));
        assertEquals(1, map.get(PrizeData.FIRST));
    }

    @Test
    public void getCumulativeMoney() {
        HashMap map = statisticsTest.doStatistics(new Lotto(new String[]{"6", "5", "4", "3", "2", "1"}));
        assertEquals(2003000000, statisticsTest.getCumulativeMoney(map));
    }

    @Test
    public void getProfitRate() {
        HashMap map = statisticsTest.doStatistics(new Lotto(new String[]{"6", "5", "4", "3", "2", "1"}));
        assertEquals(66766600, statisticsTest.getProfitRate(statisticsTest.getCumulativeMoney(map)), 0.0f);

    }
}