package sqlGenerator;

import java.util.ArrayList;

public class SQLGenerator {






    public String generateUpdateQuery(String table, ArrayList<String> oldValue, ArrayList<String> newValue) {

        String query = "UPDATE " + table + " SET ";

        for(int i = 0; i < newValue.size(); i++){

            if(i != newValue.size()-1)
                query += newValue.get(i) + ", ";
            else
                query += newValue.get(i) + " ";

        }

        query += "WHERE ";

        for(int i = 0; i < oldValue.size(); i++){
            if(i != oldValue.size()-1)
                query += oldValue.get(i) + ", ";
            else
                query += oldValue.get(i) + ";";
        }


        return query;
    }
}
