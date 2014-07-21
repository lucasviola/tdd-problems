package sqlGenerator;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

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

    public String generateSelectQuery(ArrayList<String> columns, String table, String clause, ArrayList<String> columnMatch) {

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

    public String generateInsertQuery(String table, ArrayList<String> values) {

        String query = "INSERT INTO " + table + " VALUES ";
        query += "(";

        for(int i = 0; i < values.size(); i++){

            if(values.get(i).matches("^[a-zA-Z._@!#$%&*]+$")){

                if(i != values.size()-1)
                    query += "\"" + values.get(i) + "\", ";
                else
                    query += "\"" + values.get(i) + "\"";
            }

            else{
                if(i != values.size()-1)
                    query += values.get(i) + ", ";
                else
                    query += values.get(i);
            }


        }

        query += ");";

        return query;
    }
}
