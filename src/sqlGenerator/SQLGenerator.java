package sqlGenerator;

public class SQLGenerator {

    public String generate(String table) {

        String query = "SELECT * FROM " + table + ";";

        return query;
    }
}
