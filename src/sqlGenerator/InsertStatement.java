package sqlGenerator;


import java.util.ArrayList;

public class InsertStatement {

    public String generateExpression(String table, ArrayList<String> values) {

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
