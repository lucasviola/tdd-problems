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

    public String generateSelectQuery(ArrayList<String> columns, String table, String clause, String columnMatch ){

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
        query += columnMatch + ";";

        return query;
    }

    public String generateSelectQuery(ArrayList<String> columns, String table, String clause, ArrayList<String> matches) {

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
        query += matches.get(0);
        if(matches.size() > 1){

            for(int i = 1; i < matches.size(); i++){
                query += " AND ";
                query += matches.get(i);
            }
        }

        query += ";";

        return query;
    }
}
