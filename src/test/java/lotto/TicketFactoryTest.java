package lotto;

import org.junit.Test;
import sun.awt.SunHints;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TicketFactoryTest {
    @Test
    public void createTicket() {
        List<List<Integer>> testLottoNumbers = new ArrayList<List<Integer>>();
        testLottoNumbers.add(Arrays.asList(1,2,3,4,5,6));
        testLottoNumbers.add(Arrays.asList(40,41,42,43,44,45));
        testLottoNumbers.add(Arrays.asList(15,16,17,18,19,20));

        ValueGenerator vg = new ExplicitValueGenerator(testLottoNumbers);
        List<Ticket> tickets = TicketFactory.createTicket(3, vg);

        Ticket ticket = new Ticket(Arrays.asList(1,2,3,4,5,6));
        assertThat(tickets.get(0)).isEqualTo(ticket);
        assertThat(tickets.get(1)).isNotEqualTo(ticket);
        assertThat(tickets.get(2)).isNotEqualTo(ticket);
    }
}