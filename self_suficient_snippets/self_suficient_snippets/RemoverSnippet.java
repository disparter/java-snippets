package self_suficient_snippets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoverSnippet {

	   List<String> nonDisposableObjects = Stream.of("Thing", "Printable", "Disposable", "Stuff")
			   .collect(Collectors.toList());

	    public void printNonDisposableObjects(){
	    	nonDisposableObjects.removeIf(a -> "Disposable".equals(a));
	    	nonDisposableObjects.forEach(System.out::println);
	    }

	    public static void main(String[] args) {
	        new RemoverSnippet().printNonDisposableObjects();
	    }
	
}
