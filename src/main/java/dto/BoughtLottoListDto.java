package dto;

import java.util.ArrayList;
import java.util.List;

public class BoughtLottoListDto {

    private List<LottoDto> lottoDtos;

    public BoughtLottoListDto() {
        this.lottoDtos = new ArrayList<>();
    }

    public void add(LottoDto lottoDto) {
        lottoDtos.add(lottoDto);
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}
