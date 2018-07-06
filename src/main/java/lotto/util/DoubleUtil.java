package lotto.util;

public class DoubleUtil {
    public static double roundToOneDecimal(double value) {
        return Math.round(value * 10) / 10;
    }
}
