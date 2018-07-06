package lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumberSet {

    public static List<Integer> lottoNumber = new ArrayList<>();
    static {
        for (int i = 0; i < 45; ++i) {
            lottoNumber.add(i + 1);
        }
    }

    public static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    static {
        for (int i = 0; i < 45; ++i) {
            lottoNumberMap.put(i+1 , new LottoNumber(i + 1));
        }
    }
}
