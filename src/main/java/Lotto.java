import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {

    private final int NUMBERS_LENGTH = 6;
    private List<LottoNumber> numbers;

    public Lotto() {
        initializeNumbers();
    }

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
        if (!isValid())
            throw new IllegalArgumentException();
    }

    public boolean isValid() {
        return isLengthValid() && isNonOverlapValid();
    }

    private boolean isNonOverlapValid() {
        long  distinctSize = numbers.stream()
                .map(LottoNumber::getValue)
                .distinct()
                .count();
        return distinctSize == numbers.size();
    }

    private boolean isLengthValid() {
        return numbers.size() == NUMBERS_LENGTH;
    }

    public String getLottoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            sb.append(String.valueOf(numbers.get(i)));
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2) + "]";
    }

    public void initializeNumbers() {
        numbers = new ArrayList<>();
        List<LottoNumber> pot = makeInitialPot();
        Random random = new Random();

        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            int randomIndex = random.nextInt(pot.size());
            numbers.add(pot.get(randomIndex));
            pot.remove(randomIndex);
        }
//        Collections.sort(numbers);
    }

    public List<LottoNumber> makeInitialPot() {
        List<LottoNumber> pot = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            pot.add(new LottoNumber(i));
        }
        return pot;
    }

    public int matchCount(Lotto lottoB) {
        List<LottoNumber> matchingNumbers = lottoB.numbers.stream()
                .filter(num -> containsNumber(num))
                .collect(Collectors.toList());
        return matchingNumbers.size();
    }

    private boolean containsNumber(LottoNumber number) {

        return this.numbers.contains(number);
    }
}
