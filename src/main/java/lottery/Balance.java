package lottery;

import static lottery.Lotto.LOTTO_PRICE;

public class Balance {
    int balance;

    public Balance(int balance) {
        if (balance < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.balance = balance;
    }

    public int toInt() {
        return this.balance;
    }
}
