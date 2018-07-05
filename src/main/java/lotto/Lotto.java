package lotto;

import java.util.*;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoGenerator.generateNum();
    }

    public int compareLotto(HitNumber hitNumber){
        return compareNumList(lottoNumbers, hitNumber.getNumbers());
    }

    public static int compareNumList(List<Integer> lottoNumbers, List<Integer> hitNumbers) {
        int hitCount = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            hitCount += hitNumbers.contains(lottoNumbers.get(i)) ? 1 : 0;
        }
        return hitCount;
    }
    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}