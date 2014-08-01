import java.util.ArrayList;

public class StringCalculator {

    public int add(String s) {
        String[] someName =  s.split(",");
        ArrayList<String> tokens = new ArrayList<String>();
        int result = 0;

//        for(int i = 0; i < someName.length; i++){
//            tokens.add(someName[i]);
//        }

        for(int i = 0; i < someName.length; i++){
            if(someName[i].equals("1"))
                result += 1;
            else if(someName[i].equals("2"))
                result += 2;
        }

        return result;

    }
}
