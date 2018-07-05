package dto;

import lottery.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoDto {
    private List<LottoNumber> lottoNumbers;

    public LottoDto() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void add(LottoNumber lottoNumber) {
        this.lottoNumbers.add(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
