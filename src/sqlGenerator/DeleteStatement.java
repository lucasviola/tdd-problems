package sqlGenerator;

import java.util.ArrayList;

public class DeleteStatement {

    public String generate(String table, ArrayList<String> values) {
        String query = "DELETE FROM ";
        query += table + " ";
        query += "WHERE ";
        query += values.get(0) + ";";

        return query;
    }
}
