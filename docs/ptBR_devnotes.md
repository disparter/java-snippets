# Notas do desenvolvedor

### Rabiscando os primeiros Snippets
import java.util.*;
import java.util.function.*;

```java
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
```

Esse é o Snippet modelo.
Ele utiliza o Tipo String para ser apto a descrever o objeto, dar-lhe uma característica simples de comparação
isso economiza declarar uma classe do tipo
Um jeito mais old school do java faria essa classe da seguinte maneira
package predicate;

```java
public class SimpleObject {
    public String name;
}```

Agora, refaremos PredicateSnippet da forma mais pura, com um propósito mais 'comercial', afinal você quer que sua classe seja reaproveitável em algum momento, talvez transforme-a em um módulo.
Então a idéia é que a classe tenha apenas um único propósito.
Dito isso teremos que remover a chamada main e utilizar o SimpleObject

```java
package predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicateSnippet {
    List<SimpleObject> objects;

    public void print(Predicate<SimpleObject> predicate){
        for(SimpleObject object:objects){
            if(predicate.test(object)){
                System.out.println(object);
            }
        }       
    }
}```

Mas agora não temos como observar se o comportamento desejado é o esperado, e por isso separamos a lógica de execução em um teste separado
PredicateSnippet continua tendo muitas funções e isso é um problema
ele acumula a função de imprimir ao mesmo tempo que filtra
um nome ideal para o método seria filterPrintByPredicate ... dessa forma ele representaria mais verdadeiramente o que intenta
vamos separa em 2 classes
uma que imprime pelo predicado
e o predicado em si
Vai parecer bizarro a principio
```java
package predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSnippet {
    List<SimpleObject> objects;

    public PredicateSnippet(List<SimpleObject> objects){
        this.objects = objects;
    }

    public PredicateSnippet filter(Predicate<SimpleObject> predicate){
        this.objects = objects.stream().filter(predicate).collect(Collectors.toList());
        return this;
    }

    public List<SimpleObject> collect(){
        return this.objects;
    }

}
```

Agora a lista de objetos é uma dependencia de PredicateSnippet, isso é
ele precisa de algo para trabalhar, adicionamos dois métodos também
o filter e o collect e removemos o anterior de "print"
o filter faz uma única coisa, filtra os objetos e retorna a instancia de PredicateSnippe
já collect retorna a lista de objetos
agora iremos descrever a classe de impressão

```java
package predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicatePrinter {
    
    private PredicateSnippet snippet;

    public PredicatePrinter(PredicateSnippet snippet){
        this.snippet = snippet;
    }

    public void print(List<SimpleObject> objects, Predicate<SimpleObject> predicate){
        snippet.filter(predicate).collect().forEach(o -> System.out.println(o));
    }
}
```
A classe printer vai ter apenas uma única função. 
Ela vai chamar o predicateSnippet (e depois vai imprimir o nome de cada valor da lista após o filtro). irá imprimir os objetos filtrados!
a parte da impressão não interessa tanto para nós como debug
mas a parte de filtro é interessante para saber se está filtrando corretamente
Como a printer ela lança para outra saída, precisariamos de uma outra ferramenta de teste para detectar esse comportamento. Não é tão interessante

```java
package predicate;

import java.util.Arrays;
import java.util.List;

public class PredicateSnippetTester {

    private final SimpleObject PRINTABLE_OBJECT = new SimpleObject("printable");

    public void predicateSnippetTestFiltering(){
        List<SimpleObject> testSubjects = Arrays.asList(PRINTABLE_OBJECT, new SimpleObject("banana"), PRINTABLE_OBJECT);
        List<SimpleObject> expectedSubjects = Arrays.asList(PRINTABLE_OBJECT, PRINTABLE_OBJECT);
        List<SimpleObject> result = new PredicateSnippet(testSubjects).filter(o -> PRINTABLE_OBJECT.equals(o)).collect();

        if(testSubjects.containsAll(expectedSubjects)){
            System.out.println("PredicateSnippetTester::: TEST for filtering have PASSED");
        }else {
            System.out.println("PredicateSnippetTester::: TEST for filtering have FAILED");
        }       

    }

}```

dessa maneira a classe testadora sabe como executar o teste esperado
ela tem apenas um único trabalho, garantir que após uma Snippet trablhe ela retorne com a quantidade esperada de objetos para poder serem imprimíveis
por fim a gente separa uma classe apenas para execução

```java
package predicate;

public class Main {

    public static void main(String[] args) {
        PredicateSnippetTester tester = new PredicateSnippetTester();
        tester.predicateSnippetTestFiltering();
    }
    
}```

Essa classe executa o testador declarado e por fim você manualmente confere se o resultado foi esperado
apenas para contra prova, vamos apriomorar e criar um teste falho

```java
package predicate;

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

        if(expectedSubjectsToPass.equals(result)){
            System.out.println("PredicateSnippetTester::: TEST for filtering positive have PASSED");
        }else {
            System.out.println("PredicateSnippetTester::: TEST for filtering positive have FAILED");
        }       

        if(!expectedSubjectsToFail.equals(result)){
            System.out.println("PredicateSnippetTester::: TEST for filtering negative have PASSED");
        }else {
            System.out.println("PredicateSnippetTester::: TEST for filtering negative have FAILED");
        }     
    }

}
```
Dessa maneira apos executarmos a Main novamente, ela deve imprimir:
"PredicateSnippetTester::: TEST for filtering positive have PASSED"
"PredicateSnippetTester::: TEST for filtering negative have PASSED"