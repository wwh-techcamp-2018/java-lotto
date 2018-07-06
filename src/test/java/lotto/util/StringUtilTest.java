package lotto.util;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringUtilTest {
    @Test
    public void toIntList() {
        assertThat(StringUtil.toIntList("8, 21, 23, 41, 42, 43")).isEqualTo(Arrays.asList(8, 21, 23, 41, 42, 43));
    }

    @Test
    public void writeListTest() {
        assertThat(StringUtil.writeList(Arrays.asList(8, 21, 23))).isEqualTo("[8, 21, 23]");
    }
}