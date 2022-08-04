package self_suficient_snippets;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FormatSnippet {

    private static final String VALUE_1_CONSTANT = "VALUE1";
    private static final String VALUE_2_CONSTANT = "VALUE2";

    public String getFormattedString(){
        return String.format("%s,VALUE_1,1\n" +
                        "%s,VALUE_1,0%n" +
                        "%s,VALUE_2,1\n" +
                        "%s,VALUE_2,%n",
                VALUE_1_CONSTANT,
                VALUE_1_CONSTANT,
                VALUE_2_CONSTANT,
                VALUE_2_CONSTANT);
    }

    public static void main(String[] args) {
        FormatSnippet snippet = new FormatSnippet();
        System.out.println(snippet.getFormattedString());
    }

}