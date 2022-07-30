package self_suficient_snippets;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PrimeNumberSnippet {
    public boolean isTheNumberPrime(Integer number){
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumberSnippet snippet = new PrimeNumberSnippet();
        Integer input = Integer.parseInt(args[0]);
        var start = System.currentTimeMillis();
        boolean result = snippet.isTheNumberPrime(input);
        var endTime = System.currentTimeMillis();

        System.out.format("The number %d is %s", input, result?"prime":"not prime");
        System.out.format("\nTime processing %d milliseconds", endTime - start);


    }

}