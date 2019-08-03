import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringCalculatorAdditionTest {

    private StringCalculator calculator;
    private String input;
    private int expectedSum;

    public StringCalculatorAdditionTest(String input, int expectedSum) {
        this.input = input;
        this.expectedSum = expectedSum;
    }

    @Parameterized.Parameters(name = "Test {index}: input={0}, expected sum={1}")
    public static Iterable<Object[]> data() throws Throwable {
        return Arrays.asList(new Object[][]{
                {"", 0},
                {"1", 1},
                {"1,2", 3},
                {"1,2,3,4", 10},
                {"1\n2,3", 6},
                {"//;\n1;2", 3},
                {"//and\n1and2", 3}

                //TODO edge case "//\n\n1\n2" = 3, is valid? exception?
        });
    }

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void addReturnsTheCorrectSum() throws Exception {
        assertEquals("Incorrect sum returned", expectedSum, calculator.add(input));
    }
}
