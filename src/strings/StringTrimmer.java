package strings;

public class StringTrimmer {

    public String trimSpaces(String word) {

        if(word.startsWith(" "))
            return word;

       return word.trim();
    }
}
