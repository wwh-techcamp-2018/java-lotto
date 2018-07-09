package lotto.view;

import lotto.values.Lotto;

import java.util.List;


public class GameView {
    public static void showLottoList(List<Lotto> manualLottoList, List<Lotto> autoLottoList) {
        System.out.println(getLottoCountString(manualLottoList.size(), autoLottoList.size()));
        for (Lotto lotto : manualLottoList) {
            System.out.println(lotto);
        }
        for (Lotto lotto : autoLottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    private static String getLottoCountString(int manualLottoCount, int autoLottoCount) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n수동으로 ");
        builder.append(manualLottoCount);
        builder.append("장, 자동으로 ");
        builder.append(autoLottoCount);
        builder.append("개를 구매했습니다.");
        return builder.toString();
    }
}
