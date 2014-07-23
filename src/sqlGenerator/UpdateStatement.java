package sqlGenerator;

import java.util.ArrayList;

public class UpdateStatement {

    private String query;
    private String table;
    private ArrayList<String> oldValues;
    private ArrayList<String> newValues;

    public UpdateStatement(String table, ArrayList<String> oldValues, ArrayList<String> newValues) {
        this.table = table;
        this.oldValues = oldValues;
        this.newValues = newValues;
    }

    private String addValuesToQuery(){

        query = "UPDATE " + table + " SET ";

        for(int i = 0; i < newValues.size(); i++){

            if(i != newValues.size()-1)
                query += newValues.get(i) + ", ";
            else
                query += newValues.get(i) + " ";

        }

        return query;
    }


    public String generateExpression() {

        addValuesToQuery();

        query += "WHERE ";

        for(int i = 0; i < oldValues.size(); i++){

            if(i != oldValues.size()-1)
                query += oldValues.get(i) + ", ";
            else
                query += oldValues.get(i) + ";";
        }


        return query;
    }

}
