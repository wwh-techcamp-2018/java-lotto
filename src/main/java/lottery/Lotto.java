package lottery;

import dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

import static lottery.LottoNumber.LOTTO_LENGTH;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private NumberGenerator numberGenerator;

    public Lotto() {
        this.numberGenerator = new RandomGenerator();
    }

    public Lotto(int... numbers) {
        this.numberGenerator = new FixedGenerator(numbers);
    }

    public List<LottoNumber> getLotto() {
        return this.lottoNumbers;
    }

    public static Lotto of(String numbers) {
        String[] splitted = numbers.split(",");
        int[] arr = new int[splitted.length];
        for (int i = 0; i < splitted.length; i++) {
            arr[i] = Integer.parseInt(splitted[i].trim());
        }
        return new Lotto(arr);
    }

    public void draw() {
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            this.lottoNumbers.add(this.numberGenerator.generate());
        }
    }

    public LottoDto toDto() {
        LottoDto lottoDto = new LottoDto();
        for (LottoNumber lottoNumber : lottoNumbers) {
            lottoDto.add(lottoNumber);
        }
        return lottoDto;
    }

    public Rank match(WinningLotto winningLotto) {
        int numMatched = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            numMatched += winningLotto.contains(lottoNumber);
        }
        return Rank.matchScore(numMatched);
    }

    public boolean contains(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber))
            return true;
        return false;
    }
}