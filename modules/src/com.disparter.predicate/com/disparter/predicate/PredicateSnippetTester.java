package com.disparter.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSnippetTester {

    private final SimpleObject PRINTABLE_OBJECT = new SimpleObject("printable");
    private final SimpleObject PRINTABLE_AMAZING_OBJECT = new SimpleObject("printable amazing");
    private final SimpleObject PRINTABLE_COOL_OBJECT = new SimpleObject("printable cool");
    private final SimpleObject NON_PRINTABLE_OBJECT = new SimpleObject("nonprintablE object");


    public void predicateSnippetTestFiltering(){
        List<SimpleObject> testSubjects = Arrays.asList(PRINTABLE_OBJECT, NON_PRINTABLE_OBJECT, PRINTABLE_OBJECT, PRINTABLE_AMAZING_OBJECT, PRINTABLE_COOL_OBJECT);
        List<SimpleObject> expectedSubjectsToPass = Arrays.asList(PRINTABLE_OBJECT, PRINTABLE_OBJECT, PRINTABLE_AMAZING_OBJECT, PRINTABLE_COOL_OBJECT);
        List<SimpleObject> expectedSubjectsToFail = Arrays.asList(NON_PRINTABLE_OBJECT, NON_PRINTABLE_OBJECT);
        List<SimpleObject> expectedSubjectsAmazing = Arrays.asList(PRINTABLE_AMAZING_OBJECT);
        List<SimpleObject> expectedCoolAmazingSubjects = Arrays.asList(PRINTABLE_AMAZING_OBJECT, PRINTABLE_COOL_OBJECT);


        Predicate<SimpleObject> filterPrintable = so -> so.name.contains(PRINTABLE_OBJECT.name);
        Predicate<SimpleObject> filterAmazing = so -> so.name.contains("amazing");
        Predicate<SimpleObject> filterCool = so -> so.name.contains("cool");

        List<SimpleObject> result = new PredicateSnippet(testSubjects).filter(filterPrintable).collect();
        List<SimpleObject> amazingResult = new PredicateSnippet(testSubjects).filter(filterPrintable.and(filterAmazing)).collect();
        List<SimpleObject> coolOrAmazingResult = new PredicateSnippet(testSubjects).filter(filterCool.or(filterAmazing)).collect();

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
        
        if(expectedSubjectsAmazing.equals(amazingResult)){
            System.out.println("PredicateSnippetTester::: TEST for filter and filter have PASSED");
        }else {
            errors++;
            System.err.println("PredicateSnippetTester::: TEST for filter and filter have FAILED");
        }
        
        if(expectedCoolAmazingSubjects.equals(coolOrAmazingResult)){
            System.out.println("PredicateSnippetTester::: TEST for filter or filter have PASSED");
        }else {
            errors++;
            System.err.println("PredicateSnippetTester::: TEST for filter or filter have FAILED");
        }
        
        System.exit(errors);
    }

}
