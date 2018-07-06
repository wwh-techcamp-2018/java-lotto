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


    public static boolean isValid(String answer) {
        String[] numbers = split(answer, DELIMITER);
        return Arrays.asList(numbers)
                .stream()
                .allMatch(e -> validateNumber(e)) && numbers.length == LottoGenerator.LOTTO_NUMBER_COUNT;
    }

    private static boolean validateNumber(String number) {
        int num = 0;
        try {
            num = toInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        if (num > LottoGenerator.NUMBER_UPPER_BOUND || num < LottoGenerator.NUMBER_LOWER_BOUND) return false;

        return true;
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static List<Integer> toIntList(String[] inputStr) {
        return Arrays.asList(inputStr).stream().map(e -> toInt(e)).collect(Collectors.toList());

    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

    public int increment(int number){
        if(hitNumbers.contains(number))
            return 1;
        return 0;
    }
}
