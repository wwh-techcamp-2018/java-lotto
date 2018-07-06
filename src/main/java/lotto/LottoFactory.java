package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    Generator generator;

    public LottoFactory(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generator.generate()));
        }
        return lottos;
    }
}
