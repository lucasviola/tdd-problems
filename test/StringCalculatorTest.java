import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {

        calculator = new StringCalculator();
    }

    @Test
    public void givenEmptyStringShouldReturnZero() throws Exception {

        int result = calculator.add("");

        assertThat(result, is(0));
    }

    @Test
    public void givenStringContainingOneShouldReturnOne() throws Exception {

        int result = calculator.add("1");

        assertThat(result, is(1));
    }

    @Test
    public void givenStringContainingTwoShouldReturnTwo() throws Exception {

        int result = calculator.add("2");

        assertThat(result, is(2));
    }

    @Ignore
    @Test
    public void givenTwoNumbersShouldReturnResult() throws Exception {

        int result = calculator.add("1,2");

        assertThat(result, is(3));

    }
}
