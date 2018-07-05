package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HitNumber {
    final List<Integer> hitNumbers;
    static final String DELIMITER = ", ";

    public HitNumber(String inputNumber) {
        if (!isValid(inputNumber))
            throw new IllegalArgumentException();
        hitNumbers = Collections.unmodifiableList(
                toIntList(split(inputNumber, DELIMITER)));
    }

    public List<Integer> getNumbers() {
        return hitNumbers;//Arrays.asList(new Integer[]{1,2,3,4,5,6});
    }

    public static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static List<Integer> toIntList(String[] inputStr) {
        return Arrays.asList(inputStr).stream().map(e -> toInt(e)).collect(Collectors.toList());

    }

    public static boolean isValid(String answer) {
        String[] numbers = split(answer, DELIMITER);
        return Arrays.asList(numbers)
                .stream()
                .allMatch(e -> isValidLotto(e)) && numbers.length == 6;
    }

    public static boolean isValidLotto(String number) {
        int num = 0;
        try {
            num = toInt(number);
        } catch (Exception e) {
            return false;
        }
        if (num > 45 || num < 1) return false;

        return true;
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
