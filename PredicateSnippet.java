import java.util.*;
import java.util.function.*;

public class PredicateSnippet {
    List<String> namedObjects = Arrays.asList("Thing", "Printable", "Stuff");

    public void print(Predicate<String> predicate){
        for(String object:namedObjects){
            if(predicate.test(object)){
                System.out.println(object);
            }
        }       
    }

    public static void main(String[] args) {
        PredicateSnippet snippet = new PredicateSnippet();
        snippet.print(o -> "Printable".equals(o));
    }

}