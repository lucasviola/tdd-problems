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

    @Test
    public void givenTwoNumbersShouldReturnResult() throws Exception {

        int result = calculator.add("1,2");

        assertThat(result, is(3));
    }

    @Test
    public void givenThreeNumbersShouldReturnResult() throws Exception {

        int result = calculator.add("1,2,3");

        assertThat(result, is(6));
    }

    @Test
    public void givenStringOfNumbersContainingZeroShouldReturnResult() throws Exception {

        int result = calculator.add("6,5,4,0,10");

        assertThat(result, is(25));
    }

    @Test
    public void givenTwoNumbersSeparatedByNewLineShouldReturnResult() throws Exception {

        int result = calculator.add("1\n3");

        assertThat(result, is(4));
    }

    @Test
    public void givenFiveNumbersWithTwoDifferentSeparatorsShouldReturnResult() throws Exception {

        int result = calculator.add("1\n2,5,10\n9");

        assertThat(result, is(27));

    }
}
