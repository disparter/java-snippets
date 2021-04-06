package com.disparter.predicate;

import java.util.Arrays;
import java.util.List;

public class PredicateSnippetTester {

    private final SimpleObject PRINTABLE_OBJECT = new SimpleObject("printable");
    private final SimpleObject NON_PRINTABLE_OBJECT = new SimpleObject("non printable object");


    public void predicateSnippetTestFiltering(){
        List<SimpleObject> testSubjects = Arrays.asList(PRINTABLE_OBJECT, NON_PRINTABLE_OBJECT, PRINTABLE_OBJECT);
        List<SimpleObject> expectedSubjectsToPass = Arrays.asList(PRINTABLE_OBJECT, PRINTABLE_OBJECT);
        List<SimpleObject> expectedSubjectsToFail = Arrays.asList(NON_PRINTABLE_OBJECT, NON_PRINTABLE_OBJECT);
        List<SimpleObject> result = new PredicateSnippet(testSubjects).filter(o -> PRINTABLE_OBJECT.equals(o)).collect();

        var errors = 0;
        if(expectedSubjectsToPass.equals(result)){
            System.out.println("PredicateSnippetTester::: TEST for filtering positive have PASSED");
        }else {
            errors++;
            System.err.println("PredicateSnippetTester::: TEST for filtering positive have FAILED");
        }       

        if(!expectedSubjectsToFail.equals(result)){
            System.out.println("PredicateSnippetTester::: TEST for filtering negative have PASSED");
        }else {
            errors++;
            System.err.println("PredicateSnippetTester::: TEST for filtering negative have FAILED");
        }
        System.exit(errors);
    }

}
