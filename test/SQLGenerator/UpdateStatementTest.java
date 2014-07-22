package SQLGenerator;

import org.junit.Before;
import org.junit.Test;
import sqlGenerator.SQLGenerator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UpdateStatementTest {

    SQLGenerator generator;
    String table;
    ArrayList<String> newValue;
    ArrayList<String> oldValue;

    @Before
    public void setUp() throws Exception {
        generator = new SQLGenerator();
        table = "table";
        newValue = new ArrayList<String>();
        oldValue = new ArrayList<String>();
    }

    @Test
    public void givenTableColumnAndOneValueShouldUpdateTable() throws Exception {
        newValue.add("name=\"lucas\"");
        oldValue.add("name=\"person\"");

        String result = generator.generateUpdateQuery(table, oldValue, newValue);

        assertEquals("UPDATE table SET name=\"lucas\" WHERE name=\"person\";", result);
    }

    @Test
    public void givenTableColumnAndTwoValuesShouldUpdateTable() throws Exception {
        newValue.add("name=\"lucas\"");
        newValue.add("age=24");
        oldValue.add("name=\"person\"");
        oldValue.add("age=23");

        String result = generator.generateUpdateQuery(table, oldValue, newValue);

        assertEquals("UPDATE table SET name=\"lucas\", age=24 WHERE name=\"person\", age=23;", result);
    }

    @Test
    public void givenTwoStringAndOneIntegerShouldUpdateTable() throws Exception {
        newValue.add("city=\"Porto Alegre\"");
        newValue.add("email=\"lucas@mailto.com\"");
        newValue.add("height=173");
        oldValue.add("city=\"Curitiba\"");
        oldValue.add("email=\"mail@mailto.com\"");
        oldValue.add("height=175");

        String result = generator.generateUpdateQuery(table, oldValue, newValue);

        assertEquals("UPDATE table SET city=\"Porto Alegre\", email=\"lucas@mailto.com\", height=173 WHERE city=\"Curitiba\", email=\"mail@mailto.com\", height=175;", result);
    }
}
