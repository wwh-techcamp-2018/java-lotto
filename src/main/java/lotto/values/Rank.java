package lotto.values;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
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
        return Rank.valueOf(number, false);
    }

    public static Rank valueOf(int number, boolean matchBonus) {
        return checkBonus(getRankByMatchNumber(number), matchBonus);
    }

    public int getTotalPrice(int count) {
        return count * price;
    }

    private boolean isMatches(int matches) {
        return this.matches == matches;
    }

    private static Rank getRankByMatchNumber(int number) {
        if (number >= 0 && number <= 2) {
            return MISS;
        }

        return Arrays.stream(values())
                .filter((rank) -> rank.isMatches(number))
                .findFirst()
                .orElse(null);
    }

    private static Rank checkBonus(Rank rank, boolean matchBonus) {
        if (rank == SECOND && !matchBonus) {
            return THIRD;
        }
        return rank;
    }

    @Override
    public String toString() {
        return String.format(generateFormatString(), matches, price);
    }

    public String generateFormatString() {
        if (this == SECOND) {
            return "%d개 일치, 보너스 볼 일치(%d원)";
        }
        return "%d개 일치(%d원)";
    }
}
