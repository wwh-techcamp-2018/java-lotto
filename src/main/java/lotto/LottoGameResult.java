package lotto;

public class LottoGameResult {
    private int[] matchCountArr = new int[7];
    private int totalReward;

    public void addMatchCount(int matchCount) {
        ++matchCountArr[matchCount];
    }

    public int getTotalReward() {
        for (int i = 3; i < matchCountArr.length; i++) {
            totalReward += Match.values()[i - 3].getPrice() * matchCountArr[i];
        }
        return totalReward;
    }

    public int[] getMatchCountArr() {
        return matchCountArr;
    }
}
