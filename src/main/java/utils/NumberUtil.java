package utils;

import lotto.resource.LottoNumber;

public class NumberUtil {
    public static LottoNumber[] splitString(String inputString) {
        String[] splitStrings = split(inputString);
        LottoNumber[] numbers = getLottoNumbers(splitStrings);
        return numbers;
    }

    private static String[] split(String inputString) {
        return inputString.split(",");
    }

    private static LottoNumber[] getLottoNumbers(String[] splitString) {
        LottoNumber[] numbers = new LottoNumber[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            numbers[i] = LottoNumber.ofString(splitString[i].trim());
        }
        return numbers;
    }
}
