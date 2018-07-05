import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {

    private final int NUMBERS_LENGTH = 6;
    private List<Integer> numbers;

    public Lotto() {
        initializeNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        if (!isValid())
            throw new IllegalArgumentException();
    }

    public boolean isValid() {
        return isLengthValid() && isRangeValid() && isNonOverlapValid();
    }

    private boolean isRangeValid() {
        List<Integer> validNumbers = numbers.stream()
                        .filter(num -> withinRange(num))
                        .collect(Collectors.toList());
        return numbers.size() == validNumbers.size();
    }

    private boolean isNonOverlapValid() {
        List<Integer> validNumbers = numbers.parallelStream()
                .distinct()
                .collect(Collectors.toList());
        return validNumbers.size() == numbers.size();
    }

    private boolean isLengthValid() {
        return numbers.size() == NUMBERS_LENGTH;
    }

    public boolean withinRange(int number) {
        return number <= 45 && number >= 1;
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
        List<Integer> pot = makeInitialPot();
        Random random = new Random();

        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            int randomIndex = random.nextInt(pot.size());
            numbers.add(pot.get(randomIndex));
            pot.remove(randomIndex);
        }
        Collections.sort(numbers);
    }

    public List<Integer> makeInitialPot() {
        List<Integer> pot = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            pot.add(i);
        }
        return pot;
    }

    public int matchCount(Lotto lottoB) {
        List<Integer> matchingNumbers = lottoB.numbers.stream()
                .filter(num -> containsNumber(num))
                .collect(Collectors.toList());
        return matchingNumbers.size();
    }

    private boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}
