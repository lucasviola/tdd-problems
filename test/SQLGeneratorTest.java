import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import sqlGenerator.SQLGenerator;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SQLGeneratorTest {
    SQLGenerator generator;
    String table;
    ArrayList<String> columns;


    @Before
    public void setUp() throws Exception {
        generator = new SQLGenerator();
        table = "table";
        columns = new ArrayList<String>();
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
        String clause = "WHERE";
        String columnMatch = "id=1";

        String result = generator.generateSelectQuery(columns, table, clause, columnMatch);

        assertEquals("SELECT column FROM table WHERE id=1;", result);

    }

    @Test
    public void givenOneColumnAndOneTableAndWhereClauseAndAndClauseReturnSelectQuery() throws Exception {
        columns.add("column");
        String clause = "WHERE";
        ArrayList<String> matches = new ArrayList<String>();
        matches.add("id=1");
        matches.add("age=20");

        String result = generator.generateSelectQuery(columns, table, clause, matches);

        assertEquals("SELECT column FROM table WHERE id=1 AND age=20;", result);


    }
}
