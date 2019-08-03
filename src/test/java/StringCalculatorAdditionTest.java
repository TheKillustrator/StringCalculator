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
                {"1", 1}
        });
    }

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void addReturnsTheCorrectSum() {
        assertEquals("Incorrect sum returned", expectedSum, calculator.add(input));
    }
}
