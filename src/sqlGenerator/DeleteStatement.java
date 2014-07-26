package sqlGenerator;

import java.util.ArrayList;

public class DeleteStatement {

    public String generate(String table, ArrayList<String> values) {
        String query = "DELETE FROM ";
        query += table + " ";
        query += "WHERE ";

        if(values.size() <= 1)
            query += values.get(0) + ";";
        else{
            for(int i = 0; i < values.size(); i++){
                if(i == values.size()-1)
                    query += values.get(i) + ";";
                else {
                    query += values.get(i) + " ";
                    query += "AND ";
                }
            }
        }

        return query;
    }
}
