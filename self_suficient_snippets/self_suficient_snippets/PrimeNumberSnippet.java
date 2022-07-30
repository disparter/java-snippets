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

    public boolean isTheNumberPrimeWithNoOptmization(Integer number){
        if(number < 2){
            return false;
        }else if(number == 2 || number == 3 || number == 5 || number == 7){
            return true;
        }

        String textNumber = number.toString();

        var evenlist = List.of("2","4","6","8","0");
        var threeList = List.of("3", "6", "9");

        var isEven = evenlist.stream().anyMatch(i -> textNumber.endsWith(i));

        if(isEven){
            return false;
        }

        var sumOfDigits = Arrays.stream(textNumber.split("")).mapToInt(i -> Integer.parseInt(i)).sum();
        var isMultipleOf3 = threeList.stream().anyMatch(i -> String.valueOf(sumOfDigits).equals(i));

        if(isMultipleOf3){
            return false;
        }

        var isMultipleOf5 = textNumber.endsWith("5");

        if(isMultipleOf5){
            return false;
        }

        for(int i = 7; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }

    public boolean isTheNumberPrimeWithOptmization(Integer number){
        if(number < 2){
            return false;
        }else if(number == 2 || number == 3 || number == 5 || number == 7){
            return true;
        }

        if(number % 2 == 0
            || number % 3 == 0
            || number % 5 == 0
            || number % 7 == 0) {

            return false;
        }

        for(int i = 7; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumberSnippet snippet = new PrimeNumberSnippet();
        Integer input = Integer.parseInt(args[0]);
        var start = System.nanoTime();
        boolean result = snippet.isTheNumberPrime(input);
        var endTime = System.nanoTime();

        System.out.format("The number %d is %s", input, result?"prime":"not prime");
        System.out.format("\nTime processing %d milliseconds", endTime - start);

        var start2 = System.nanoTime();
        boolean result2 = snippet.isTheNumberPrimeWithNoOptmization(input);
        var endTime2 = System.nanoTime();

        System.out.format("\nThe number %d is %s", input, result2?"prime":"not prime");
        System.out.format("\nTime processing %d milliseconds", endTime2 - start2);

        var start3 = System.nanoTime();
        boolean result3 = snippet.isTheNumberPrimeWithOptmization(input);
        var endTime3 = System.nanoTime();

        System.out.format("\nThe number %d is %s", input, result3?"prime":"not prime");
        System.out.format("\nTime processing %d milliseconds", endTime3 - start3);


    }

}
