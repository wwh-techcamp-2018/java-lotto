package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    LottoGenerator generator;

    public LottoFactory(){
        this.generator = new LottoGenerator();
    }
    public List<Lotto> createLotto(int maxLottoCount) {
        List<Lotto> newLottoes = new ArrayList<Lotto>();
        for (int i = 0; i < maxLottoCount; i++) {
            newLottoes.add(new Lotto());
        }
        return newLottoes;
    }
}
