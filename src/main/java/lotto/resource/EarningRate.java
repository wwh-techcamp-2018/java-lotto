package lotto.resource;

import java.util.Objects;

public class EarningRate {
    private double earningRate;

    public EarningRate(double inputDouble) {
        this.earningRate = inputDouble;
    }

    public EarningRate(Money inputMoney){
        this.earningRate = inputMoney.getMoney();
    }

    public double getEarningRate() {
        return earningRate;
    }

    public static EarningRate round(EarningRate inputEarningRate) {
        double earningRate = inputEarningRate.getEarningRate();
        earningRate *= 10;
        earningRate = Math.round(earningRate);
        earningRate /= 10;
        return new EarningRate(earningRate);
    }

    public EarningRate add(double inputEarningRate) {
        return new EarningRate(earningRate + inputEarningRate);
    }

    public static EarningRate getPercentage(EarningRate dividedNumber, EarningRate divideNumber) {
        return new EarningRate(dividedNumber.getEarningRate() / divideNumber.getEarningRate() * 100);
    }

    public static EarningRate getPercentage(Money earingMoney, Money price) {
        return new EarningRate(new EarningRate(earingMoney).getEarningRate() / new EarningRate(price).getEarningRate() * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarningRate that = (EarningRate) o;
        return Double.compare(that.earningRate, earningRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate);
    }
}
