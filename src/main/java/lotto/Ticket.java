package lotto;

import lotto.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ticket {
    private List<LottoNumber> numbers;


    public Ticket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int match(WinningTicket winningTicket) {
        int count = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            count = count + winningTicket.contains(this.numbers.get(i));
        }

        return count;
    }

    public int contains(LottoNumber lottonum) {
        if (this.numbers.contains(lottonum))
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(numbers, ticket.numbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numbers);
    }

    public String toString() {
        return StringUtil.writeList(LottoNumber.toIntList(numbers));
    }
}
