package sqlGenerator;

import java.util.ArrayList;

public class SQLGenerator {

    public String fromTableNameToSelectQuery(String table) {

        String query = "SELECT * FROM " + table + ";";

        return query;
    }

    public String generateSelectQuery(ArrayList<String> columns, String table) {

        String query = "SELECT ";

        if(columns.isEmpty())
            query += "*";
        else {
            for(int i = 0; i < columns.size(); i++)
                query += columns.get(i) + " ";
        }

        query += "FROM " + table + ";";

        return query;
    }
}
