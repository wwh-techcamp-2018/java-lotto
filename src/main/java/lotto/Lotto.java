package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto()
    {
//        lottoNumbers = LottoGenerator.generateNum();
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
       // return compareNumList(lottoNumbers, hitNumber.getNumbers());
    }

//    public static int compareNumList(List<Integer> lottoNumbers, List<Integer> hitNumbers) {
//        int hitCount = 0;
//        for (int i = 0; i < lottoNumbers.size(); i++) {
//            hitCount += hitNumbers.contains(lottoNumbers.get(i)) ? 1 : 0;
//        }
//        return hitCount;
//    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}