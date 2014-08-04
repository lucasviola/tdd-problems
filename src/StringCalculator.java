import java.util.ArrayList;

public class StringCalculator {

    private String separator;
    private String[] separatedSentence;

    public int add(String sentence) {

        if(sentence.length() >= 2){
            if(sentence.charAt(1) == '\n')
                separator = "\n";
            else
                separator = ",";
        }
        else
            separator = ",";



        separatedSentence = separateNumbers(sentence, separator);
        int result = 0;

        for(int i = 0; i < separatedSentence.length; i++){
            if(separatedSentence[i].equals(""))
                result = 0;
            else{
                result += Integer.parseInt(separatedSentence[i]);
            }
        }

        return result;

    }

    private String[] separateNumbers(String sentence, String separator) {
        return sentence.split(separator);
    }
}
