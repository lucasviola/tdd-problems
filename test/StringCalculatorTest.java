import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringCalculatorTest {

    @Test
    public void givenEmptyStringShouldReturnZero() throws Exception {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("");

        assertThat(result, is(0));
    }

    @Test
    public void givenStringContainingOneShouldReturnOne() throws Exception {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1");

        assertThat(result, is(1));
    }

    @Test
    public void givenStringContainingTwoShouldReturnTwo() throws Exception {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("2");

        assertThat(result, is(2));

    }
}
