package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto()
    {
        this(LottoGenerator.generateNum());
    }

    private Lotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }


    public static Lotto getLottoByInput(List<Integer> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    public int compareLotto(HitNumber hitNumber) {
        int count = 0 ;
        for(int number : lottoNumbers) {
            count += hitNumber.increment(number);
        }
        return count;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}