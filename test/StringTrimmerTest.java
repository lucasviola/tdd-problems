import org.junit.Test;
import strings.StringTrimmer;

import static org.junit.Assert.*;

public class StringTrimmerTest {

    @Test
    public void shouldTrimWhitespaceAtTheEndOfAGivenWord() throws Exception {
        //arrange
        StringTrimmer trimmer = new StringTrimmer();

        //act
        String result = trimmer.trimSpaces("abc ");

        //assert
        assertEquals("abc", result);

    }

    @Test
    public void shouldTrimTabAtTheEndOfAGivenWord() throws Exception {
        StringTrimmer trimmer = new StringTrimmer();
        
        String result = trimmer.trimSpaces("abc ");

        assertEquals("abc", result);
    }

    @Test
    public void shouldNotRemoveWhiteSpaceAtTheBeginningOfAGivenWord() throws Exception {
        StringTrimmer trimmer = new StringTrimmer();

        String result = trimmer.trimSpaces(" abc");

        assertEquals(" abc", result);

    }

    @Test
    public void shouldNotRemoveNewLineOfAGivenString() throws Exception {
        StringTrimmer trimmer = new StringTrimmer();

        String result = trimmer.trimSpaces("ab" + "\n" + "cd" + " ");

        assertEquals("ab\ncd", result);
    }
}
