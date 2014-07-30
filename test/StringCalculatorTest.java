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
}
