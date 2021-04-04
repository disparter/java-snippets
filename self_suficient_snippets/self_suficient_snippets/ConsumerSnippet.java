package self_suficient_snippets;

import java.util.Arrays;
import java.util.List;

public class ConsumerSnippet {
    List<String> namedObjects = Arrays.asList("Thing", "Printable", "Stuff");

    public void print(){
        namedObjects.forEach(System.out::println);      
    }

    public static void main(String[] args) {
        new ConsumerSnippet().print();
    }

}