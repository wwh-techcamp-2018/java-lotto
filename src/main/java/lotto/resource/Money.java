package lotto.resource;

public class Money {
    private Integer money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public Money(String inputString) {
        this(toInt(inputString));
    }

    private static int toInt(String inputString) {
        if(inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }

    public Money add(int money) {
        return new Money(this.money + money);
    }

    public Integer getMoney() {
        return money;
    }
}
