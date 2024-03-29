import exception.NegativeNumberException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNotNull;

public class StringCalculatorTests {

    private StringCalculator calculator;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    public void addTakesStringAndReturnsAnInt() throws Exception {
        int sum = Integer.valueOf(calculator.add(""));
        assertNotNull(sum);
    }

    @Test
    public void negativeNumbersThrowException() throws Exception {
        expectedEx.expect(NegativeNumberException.class);
        expectedEx.expectMessage("Negatives not allowed: [-1, -2]");
        int sum = calculator.add("1,-1,2,-2");
    }
}
