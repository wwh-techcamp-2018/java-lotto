package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String COMMA = ",";

    public static List<String> splitByComma(String input) {
        List<String> list = new ArrayList<>();
        String[] values = input.split(COMMA);
        for (String value : values) {
            list.add(value.trim());
        }
        return list;
    }

    public static List<Integer> toInts(List<String> tokens){
        return tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
