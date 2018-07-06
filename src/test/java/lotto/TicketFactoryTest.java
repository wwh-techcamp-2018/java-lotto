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
        List<List<Integer>> userLottoNumbers = new ArrayList<List<Integer>>();
        userLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        userLottoNumbers.add(Arrays.asList(40, 41, 42, 43, 44, 45));
        userLottoNumbers.add(Arrays.asList(15, 16, 17, 18, 19, 20));

        ValueGenerator userVG = new ExplicitValueGenerator(userLottoNumbers);
        List<Ticket> userTickets = TicketFactory.createTicket(3, userVG);

        Ticket targetTicket = new Ticket(LottoNumber.listOf(1, 2, 3, 4, 5, 6));
        assertThat(userTickets.get(0)).isEqualTo(targetTicket);
        assertThat(userTickets.get(1)).isNotEqualTo(targetTicket);
        assertThat(userTickets.get(2)).isNotEqualTo(targetTicket);
    }
}