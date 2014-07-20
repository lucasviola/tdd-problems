import org.junit.Test;
import sqlGenerator.SQLGenerator;

import static org.junit.Assert.*;

public class SQLGeneratorTest {

    @Test
    public void givenTableNameShouldQueryForEverythingInTheTable() throws Exception {
        SQLGenerator generator = new SQLGenerator();

        String table = "a";
        String result = generator.generate(table);

        assertEquals("SELECT * FROM " + table + ";", result);

    }
}
