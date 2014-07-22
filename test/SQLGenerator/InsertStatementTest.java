package SQLGenerator;

import org.junit.Before;
import org.junit.Test;
import sqlGenerator.SQLGenerator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class InsertStatementTest {
    SQLGenerator generator;
    String table;
    @Before
    public void setUp() throws Exception {
         generator = new SQLGenerator();
         table = "table";

    }

    @Test
    public void givenTwoValuesShouldInsertIntoTable() throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        values.add("lucas");
        values.add("24");

        String result = generator.generateInsertQuery(table, values);

        assertEquals("INSERT INTO table VALUES (\"lucas\", 24);", result);
    }

    @Test
    public void givenTwoStringsShouldInsertIntoTable() throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        values.add("lucas");
        values.add("Brasil");

        String result = generator.generateInsertQuery(table, values);

        assertEquals("INSERT INTO table VALUES (\"lucas\", \"Brasil\");", result);

    }

    @Test
    public void givenOneSingleValueShouldInsertIntoTable() throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        values.add("24");

        String result = generator.generateInsertQuery(table, values);

        assertEquals("INSERT INTO table VALUES (24);", result);
    }

    @Test
    public void givenTwoIntegersShouldInsertIntoTable() throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        values.add("1");
        values.add("24");

        String result = generator.generateInsertQuery(table, values);

        assertEquals("INSERT INTO table VALUES (1, 24);", result);
    }

    @Test
    public void givenThreeStringsShouldInsertIntoTable() throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        values.add("lucas");
        values.add("mail@mailto.com");
        values.add("Brasil");

        String result = generator.generateInsertQuery(table, values);

        assertEquals("INSERT INTO table VALUES (\"lucas\", \"mail@mailto.com\", \"Brasil\");", result);
    }

    @Test
    public void givenASetOfSpecialSymbolsShouldValidateAsAString() throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        values.add("!@#$%*");

        String result = generator.generateInsertQuery(table, values);

        assertEquals("INSERT INTO table VALUES (\"!@#$%*\");", result);
    }
}
