package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<Integer> toIntList(String input) {
        String[] tokens = input.split(", ");
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(Integer.parseInt(token));
        }
        return result;
    }

    public static String writeList(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i) + ", ");
        }
        sb.append(numbers.get(numbers.size() - 1) + "]");
        return sb.toString();
    }
}
