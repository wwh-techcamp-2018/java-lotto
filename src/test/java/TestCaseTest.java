import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseTest {
    class TestOutput {
        private String prop1;
        private int prop2;

        TestOutput(String prop1, int prop2) {
            this.prop1 = prop1;
            this.prop2 = prop2;
        }
    }

    List outputList;
    String[] outputArr;
    TestOutput outputBean;

    String outputStr;
    int outputInt;

    String nullObj;

    @Before
    public void setUp() {
        nullObj = null;
        outputStr = "ABC";
        outputInt = 1;
        outputList = new ArrayList();
        outputList.add("A-B1");
        outputList.add("A-B2");
        outputList.add("A-B3");
        outputArr = new String[]{"A-B1", "A-B2", "A-B3"};
        outputBean = new TestOutput(outputStr, outputInt);

    }

    @Test
    public void contains() {
        assertThat("A-B1").isIn(outputList).contains("A-B2", "A-B3");
    }
}
