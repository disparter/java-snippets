package com.disparter.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphaNOCaseComparatorSnippetTester {

    public void test_allCases(){
    	final List<String> EXPECTED = Arrays.asList("a", "b", "b", "c");
    	List<String> subjectList = Arrays.asList("c", "b", "a", "b");
    	List<String> result = subjectList.stream()
		          .sorted(new AlphaNoCaseComparatorSnippet())
		          .collect(Collectors.toList());
    	
    	if(EXPECTED.equals(result)) {
    		System.out.print("AlphaNOCaseComparatorSnippetTester::test_AllCases -> Success");
    	}else {
    		System.out.print("AlphaNOCaseComparatorSnippetTester::test_AllCases -> Failure");
    	}
    	
		System.out.printf("EXPECTED {%s} - RECEIVED {%s}", EXPECTED, result);
    	
    }
    
}
