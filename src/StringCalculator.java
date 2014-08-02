import java.util.ArrayList;

public class StringCalculator {

    public int add(String sentence) {
        String[] separatedSentence = separateNumbers(sentence, ",");
        int result = 0;

        for(int i = 0; i < separatedSentence.length; i++){
            if(separatedSentence[i].equals(""))
                result = 0;
            else
                result += Integer.parseInt(separatedSentence[i]);
        }

        return result;

    }

    private String[] separateNumbers(String sentence, String separator) {
        return sentence.split(separator);
    }
}
