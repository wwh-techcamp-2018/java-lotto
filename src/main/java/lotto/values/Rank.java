package lotto.values;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private final int matches;
    private final int price;

    Rank(int matches, int price) {
        this.matches = matches;
        this.price = price;
    }

    public int getMatches() {
        return matches;
    }

    public int getPrice() {
        return price;
    }

    public static Rank valueOf(int number) {
        if (number >= 0 && number <= 2)  {
            return MISS;
        }

        return Arrays.stream(values())
                .filter((rank) -> rank.isMatches(number))
                .findFirst()
                .orElse(null);
    }

    public int getTotalPrice(int count) {
        return count * price;
    }

    private boolean isMatches(int matches) {
        return this.matches == matches;
    }
}
