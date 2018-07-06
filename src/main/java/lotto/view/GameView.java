package lotto.view;

import lotto.values.Lotto;

import java.util.List;


public class GameView {
    public static void showLottoList(List<Lotto> lottoList) {
        System.out.println("" + lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
