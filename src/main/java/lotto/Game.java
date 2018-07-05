package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final Map<Integer, Integer> map;

    public Game(int money) {
        this.lottos = LottoFactory.create(money / LOTTO_PRICE);
        this.map = initMap();
    }

    private Map<Integer, Integer> initMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        return map;
    }

    public Game(Lotto lotto) {
        this.lottos = Arrays.asList(lotto);
        this.map = initMap();
    }

    public Map<Integer, Integer> match(String s) {
        return winningList(getIntegers(s));
    }

    private Map<Integer, Integer> winningList(List<Integer> list) {
        for (Lotto lotto : lottos) {
            Integer num = lotto.existCount(list);
            if(num > 2)
                this.addWins(num);
        }
        return this.map;
    }

    static List<Integer> getIntegers(String numString) {
        return Arrays.stream(numString.split(","))
                .map(t -> Integer.parseInt(t.trim()))
                .collect(Collectors.toList());
    }

    private void addWins(Integer num) {
        addWins(num, this.map);
    }

    static void addWins(Integer i, Map<Integer, Integer> map) {
        synchronized (map) {
            Integer value = map.getOrDefault(i, 0);
            map.put(i, ++value);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
