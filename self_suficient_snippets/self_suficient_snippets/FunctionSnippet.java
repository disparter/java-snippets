package self_suficient_snippets;

import java.util.stream.IntStream;

public class FunctionSnippet {

	    public void printFirstHunderedSquares() {
			IntStream.rangeClosed(1, 100).mapToObj(n -> n*n).forEach(System.out::println);
	    }

	    public static void main(String[] args) {
	        new FunctionSnippet().printFirstHunderedSquares();
	    }
}
