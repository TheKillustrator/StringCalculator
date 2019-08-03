import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StringCalculatorTests {

    private StringCalculator calculator;

    @Before
    public void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    public void addTakesStringAndReturnsAnInt() throws Exception {
        int sum = Integer.valueOf(calculator.add(""));
        assertNotNull(sum);
    }

    @Test(expected = Exception.class)
    public void negativeNumbersThrowException() throws Exception {
        int sum = calculator.add("1,-1,2,-2");
    }
}
