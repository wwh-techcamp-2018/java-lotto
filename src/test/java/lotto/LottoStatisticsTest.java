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
        LottoContainer tempLottoContainer = new LottoContainer(tempLotto);

        statisticsTest = new LottoStatistics(tempLottoContainer);
    }

    @Test
    public void doStatistics() {
        Map map = statisticsTest.doStatistics(new Lotto(new String[]{"6", "5", "4", "3", "2", "1"}));
        assertEquals(1, map.get("_"+6));
        assertEquals(1, map.get("_"+5));
    }

    @Test
    public void getCumulativeMoney() {
        HashMap map = statisticsTest.doStatistics(new Lotto(new String[]{"6", "5", "4", "3", "2", "1"}));
        assertEquals(2000000000, statisticsTest.getCumulativeMoney(map));
    }

    @Test
    public void getProfitRate() {
        HashMap map = statisticsTest.doStatistics(new Lotto(new String[]{"6", "5", "4", "3", "2", "1"}));
        assertEquals(200000000.0, statisticsTest.getProfitRate(statisticsTest.getCumulativeMoney(map)), 0.0f);

    }
}