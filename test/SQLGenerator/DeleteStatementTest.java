package SQLGenerator;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import sqlGenerator.DeleteStatement;

import java.util.ArrayList;

public class DeleteStatementTest {

    @Test
    public void givenTableAndIdShouldDelete() throws Exception {
        String table = "table";
        ArrayList<String> values = new ArrayList<String>();
        values.add("id=1");
        DeleteStatement generator = new DeleteStatement();

        String result = generator.generate(table, values);

        assertThat(result, is("DELETE FROM table WHERE id=1;"));
    }
}
