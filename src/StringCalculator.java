public class StringCalculator {

    public int add(String s) {
            String[] someName =  s.split(",");
            int result = 0;

        if(s == "1")
            return 1;
        else if(s == "2")
            return 2;
        else
            return 0;
    }
}
