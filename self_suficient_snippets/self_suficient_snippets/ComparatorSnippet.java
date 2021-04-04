package self_suficient_snippets;

import java.util.Arrays;
import java.util.List;

public class ComparatorSnippet {
	   List<String> namedObjects = Arrays.asList("Thing", "Printable", "Stuff", "Stuff");

	    public void printSorted(){
	        namedObjects.sort((a,b) -> {return a.compareToIgnoreCase(b);});
	        namedObjects.forEach(System.out::println);
	    }

	    public static void main(String[] args) {
	        new ComparatorSnippet().printSorted();
	    }
}
