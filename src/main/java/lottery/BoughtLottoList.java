package lottery;

import dto.BoughtLottoListDto;
import dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

public class BoughtLottoList {

    private List<Lotto> lottos;

    public BoughtLottoList(){
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottoDtos() {
        return lottos;
    }

    public void add(Lotto lotto){
        lottos.add(lotto);
    }

    public BoughtLottoListDto toDto() {
        BoughtLottoListDto boughtLottoListDto = new BoughtLottoListDto();
        for (Lotto lotto : lottos) {
            boughtLottoListDto.add(lotto.toDto());
        }
        return boughtLottoListDto;
    }
}
