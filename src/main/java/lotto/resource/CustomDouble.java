package lotto.resource;

import java.util.Objects;

public class CustomDouble {
    private double customDouble;

    public CustomDouble(double inputDouble) {
        this.customDouble = inputDouble;
    }

    public double getCustomDouble() {
        return customDouble;
    }

    public static CustomDouble round(CustomDouble inputDouble) {
        double tempDouble = inputDouble.getCustomDouble();
        tempDouble *= 10;
        tempDouble = Math.round(tempDouble);
        tempDouble /= 10;
        return new CustomDouble(tempDouble);
    }

    public CustomDouble add(double inputDouble) {
        return new CustomDouble(customDouble + inputDouble);
    }

    public static CustomDouble getPercentage(CustomDouble dividedNumber, Positive divideNumber) {
        return new CustomDouble(dividedNumber.getCustomDouble() / divideNumber.getNumber() * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDouble that = (CustomDouble) o;
        return Double.compare(that.customDouble, customDouble) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customDouble);
    }
}
