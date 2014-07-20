import org.junit.Test;
import sqlGenerator.SQLGenerator;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SQLGeneratorTest {

    @Test
    public void givenTableNameShouldQueryForEverythingInTheTable() throws Exception {
        SQLGenerator generator = new SQLGenerator();

        String table = "a";
        String result = generator.fromTableNameToSelectQuery(table);

        assertEquals("SELECT * FROM " + table + ";", result);
    }

    @Test
    public void givenAColumnAndTableShouldReturnSelectQuery() throws Exception {
        SQLGenerator generator = new SQLGenerator();
        String table = "table";
        ArrayList<String> columns = new ArrayList<String>();
        columns.add("column");

        String result = generator.generateSelectQuery(columns, table);

        assertEquals("SELECT column FROM " + table + ";", result);


    }
}
