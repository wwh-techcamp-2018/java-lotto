package lotto;

import lotto.util.stringUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ticket {
    List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public int match(Ticket winningTicket) {
        int cnt = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            cnt = cnt + winningTicket.contains(this.numbers.get(i));
        }
        return cnt;
    }

    private int contains(Integer integer) {
        if (this.numbers.contains(integer))
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
        return stringUtil.writeList(numbers);
    }
}
