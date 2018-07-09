package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void format() {
        assertThat(String.format("%d;%d", 3, 300_000_000L)).isEqualTo("3;300000000");
    }
}
