package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<Integer> parse(String input) {
        String[] splited = input.split(",");
        return Arrays.stream(splited)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
