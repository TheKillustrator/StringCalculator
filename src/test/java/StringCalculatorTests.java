import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringCalculatorTests {

    private StringCalculator calculator;

    @Before
    public void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    public void addTakesStringAndReturnsAnInt(){
        int sum = Integer.valueOf(calculator.add(""));
        assertNotNull(sum);
    }

    @Test
    public void addReturnsTheCorrectSum(){
        assertEquals("Incorrect sum returned", 0, calculator.add(""));
    }
}
