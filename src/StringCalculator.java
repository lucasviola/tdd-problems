import java.util.ArrayList;

public class StringCalculator {

    public int add(String s) {
        String[] someName =  s.split(",");
        int result = 0;

        for(int i = 0; i < someName.length; i++){
            if(someName[i].equals(""))
                result = 0;
            else
                result += Integer.parseInt(someName[i]);
        }

        return result;

    }
}
