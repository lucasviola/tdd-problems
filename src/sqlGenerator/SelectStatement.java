package sqlGenerator;

import java.util.ArrayList;

public class SelectStatement {
    public String fromTableNameToSelectQuery(String table) {

        String query = "SELECT * FROM " + table + ";";

        return query;
    }

    public String generateExpression(ArrayList<String> columns, String table) {

        String query = "SELECT ";
        if(columns.isEmpty())
            query += "*";
        else {
            for(int i = 0; i < columns.size(); i++){

                if(i == columns.size()-1)
                    query += columns.get(i) + " ";
                else
                    query += columns.get(i) + ", ";
            }
        }

        query += "FROM " + table + ";";

        return query;
    }

    public String generateExpression(ArrayList<String> columns, String table, String clause, ArrayList<String> columnMatch) {

        String query = "SELECT ";

        if(columns.isEmpty())
            query += "*";
        else {
            for(int i = 0; i < columns.size(); i++){

                if(i == columns.size()-1)
                    query += columns.get(i) + " ";
                else
                    query += columns.get(i) + ", ";
            }
        }

        query += "FROM " + table + " ";
        query += clause + " ";
        query += columnMatch.get(0);
        if(columnMatch.size() > 1){

            for(int i = 1; i < columnMatch.size(); i++){
                query += " AND ";
                query += columnMatch.get(i);
            }
        }

        query += ";";

        return query;
    }
}
