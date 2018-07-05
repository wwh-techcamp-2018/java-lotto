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
}