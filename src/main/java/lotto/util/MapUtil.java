package lotto.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    public static Map<Integer, Integer> mapBuilder(int[] keys, int[] values) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < keys.length; i++) {
            resultMap.put(keys[i], values[i]);
        }
        return resultMap;
    }
}
