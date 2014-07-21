import org.junit.Before;
import org.junit.Test;
import sqlGenerator.SQLGenerator;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SQLGeneratorTest {
    SQLGenerator generator;
    String table;
    ArrayList<String> columns;
    ArrayList<String> columnMatch;
    String clause;

    @Before
    public void setUp() throws Exception {
        generator = new SQLGenerator();
        table = "table";
        clause = "WHERE";
        columns = new ArrayList<String>();
        columnMatch = new ArrayList<String>();
    }

    @Test
    public void givenTableNameShouldQueryForEverythingInTheTable() throws Exception {
        String table = "a";
        String result = generator.fromTableNameToSelectQuery(table);

        assertEquals("SELECT * FROM " + table + ";", result);
    }

    @Test
    public void givenAColumnAndTableShouldReturnSelectQuery() throws Exception {
        columns.add("column");

        String result = generator.generateSelectQuery(columns, table);

        assertEquals("SELECT column FROM " + table + ";", result);
    }

    @Test
    public void givenTwoColumnsAndATableShouldReturnSelectQuery() throws Exception {
        columns.add("firstColumn");
        columns.add("secondColumn");

        String result = generator.generateSelectQuery(columns, table);

        assertEquals("SELECT firstColumn, secondColumn FROM table;", result);
    }

    @Test
    public void givenThreeColumnsAndATableShouldReturnSelectQuery() throws Exception {
        columns.add("firstColumn");
        columns.add("secondColumn");
        columns.add("thirdColumn");

        String result = generator.generateSelectQuery(columns, table);

        assertEquals("SELECT firstColumn, secondColumn, thirdColumn FROM table;", result);

    }

    @Test
    public void givenOneColumnAndOneTableAndWhereClauseShouldReturnSelectQuery() throws Exception {
        columns.add("column");
        columnMatch.add("id=1");

        String result = generator.generateSelectQuery(columns, table, clause, columnMatch);

        assertEquals("SELECT column FROM table WHERE id=1;", result);

    }

    @Test
    public void givenOneColumnAndOneTableAndWhereClauseAndAndClauseReturnSelectQuery() throws Exception {
        columns.add("column");
        columnMatch.add("id=1");
        columnMatch.add("age=20");

        String result = generator.generateSelectQuery(columns, table, clause, columnMatch);

        assertEquals("SELECT column FROM table WHERE id=1 AND age=20;", result);
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

    @Test
    public void givenTableAndOnePairOfColumnValueShouldUpdateTable() throws Exception {
        ArrayList<String> newValue = new ArrayList<String>();
        newValue.add("name=\"lucas\"");
        ArrayList<String> oldValue = new ArrayList<String>();
        oldValue.add("name=\"person\"");

        String result = generator.generateUpdateQuery(table, oldValue, newValue);

        assertEquals("UPDATE table SET name=\"lucas\" WHERE name=\"person\";", result);
    }
}
