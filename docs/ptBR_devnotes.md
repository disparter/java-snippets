# Notas do desenvolvedor

### Rabiscando os primeiros Snippets
```java
import java.util.*;
import java.util.function.*;

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
}
```

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
}
```

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

}
```

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
    
}
```

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

### Operador Tenário
```java
package self_suficient_snippets;

public class TenarySnippet {
    public static void main(String... args){
        if(args != null && args.length > 0 && args[0] != null && Boolean.parseBoolean(args[0])){
           System.out.println("Verdadeiro");  
        }else{
           System.out.println("Falso");  
        }
      }
}
```
```java
public class ExemploDeTenario{
  public static void main(String... args){
    Objects.requiresNonNull(args[0]);
    System.out.println(args[0]?"Verdadeiro":"Falso");
  }
}
```

https://github.com/disparter/java-snippets/blob/main/self_suficient_snippets/self_suficient_snippets/TenarySnippet.java
```java
package self_suficient_snippets;

public class TenarySnippet {
    public static void main(String... args){
        if(checkArgs(args)){
           System.out.println("Verdadeiro");  
        }else{
           System.out.println("Falso");  
        }
        
        System.out.println(checkArgs(args)?"Verdadeiro":"Falso");
      }
    
    public static Boolean checkArgs(String... args) {
        return args.length > 0 && Boolean.parseBoolean(args[0]);
    }
}
```

Colocando tudo junto pra ficar mais claro e corrigindo os erros de sintaxe acima do rascunho
No caso de args... para o Java nunca vem nulo então não precisa checar, isso é bom pq ai é só verificar se o array tem numero de argumentos maior que 0
E dai seu programa está esperando que seja um true or false como argumento
Se fosse rodar isso na linha de comando seria algo assim
java TenarySnippet true

### Programação Funcional
Vamos dar uma olhada nesse artigo do Alura
https://www.alura.com.br/artigos/programacao-funcional-o-que-e#:~:text=Programa%C3%A7%C3%A3o%20funcional%20%C3%A9%20o%20processo,Elliott%20que%20eu%20gosto%20muito.

Antes de ler o artigo um rascunho breve:
A programação tem uns paradigmas. Umas maneiras chaves de fazer as coisas
A programação estrutural é aquela que vai do inicio pro fim do arquivo
leitura de linha a linha, que nem em uma maquina de escrever
ai tem a Programação Orientada a Objetos
que é nosso foco maior
Pois o java é completamente orientado
E agora a programação Funcional é outro paradigma em si
ela tem seus propios defeitos e beneficios e a ideia desse artigo é utiliza-la nos módulos como temos feito nos commits anteriores
Esses módulos agora possuem o objetivo de analisar a programação funcional no java
Por agora vamos criar um módulo que provê uma implementação para Function

#### Function
função Function no java é definida como a seguinte

```java
@FunctionalInterface
public interface Function<T, R> {
    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
}
```

Existem mais dois default métodos mas não passaremos por eles pois não interessam pro propósito de implementação
A Function determina um método apply que recebe um Tipo qualquer e Retorna um outro Tipo
Podem ser diferentes ou iguais
Uma simples implementação de Function poderia ser uma Potência Quadrática
Por definição qualquer número elevado a 2 é um quadrado de si mesmo
daí da simples implementação
package com.disparter.function;

```java
import java.util.function.Function;
import java.lang.Number;

public class SquaredFunction implements Function<Integer, Integer>{

    @Override
    public Integer apply(Integer number){
        return number * number;
    }
    
}
```
O tipo R e T foram definidos como Integer
Simples ne?
Apenas pensando em Function já da pra fazer mta coisa
Uma Snippet Simples poderia ser
```java
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
```
basicamente imprime os 100 primeiros quadrados
alem de aprimorar a legibilidade, existem alguns detalhes que são necessários para se fazer uma boa implementação

#### BiFunction
Assim como a interface Function
a interface BiFunction é uma interface que recebe um parametro e retorna um outro tipo de objeto.
Nesse caso a unica diferença é que a BiFunction usa dois parametros ao inves de 1
O que torna muito interessante e forte candidato a operações basicas de matemática, como por exemplo. Somar, Dividir
a entrada sempre são 2 numeros e a saída sempre 1 numero
O módulo Calculator provê 4 implementações básicas para serem usadas
https://github.com/disparter/java-snippets/tree/master/modules/src/com.disparter.calculator
Além do UnaryOperator e do Binary Operator, irei fazer mais algums módulos com Interfaces funcionais próprias antes de encerrar esse assunto

#### BinaryOperator

Continuando as interfaces. A UnaryOperator e a BinaryOperator são lindas
Quando iniciamos a calculadora, ela usava Function<T, R> que apesar de poder ter dois tipos diferentes nós usamos apenas um tipo
mas essa característica é da UnaryOperator, pois afinal é apenas uma extensão de Function
Que permite apenas um mesmo tipo, são elas mais usadas nas Streams pois Possuem o mesmo tipo
Faremos um refactor em Calculator
Repare no Diff.
BinaryOperator utiliza apenas um argumento o que torna mais prática a escrita para esse caso.

```diff
diff --git a/modules/src/com.disparter.calculator/com/disparter/calculator/Adder.java b/modules/src/com.disparter.calculator/com/disparter/calculator/Adder.java
index 9d25c97..fe23315 100644
--- a/modules/src/com.disparter.calculator/com/disparter/calculator/Adder.java
+++ b/modules/src/com.disparter.calculator/com/disparter/calculator/Adder.java
@@ -1,8 +1,8 @@
 package com.disparter.calculator;

-import java.util.function.BiFunction;
+import java.util.function.BinaryOperator;

-public class Adder implements BiFunction<Integer, Integer, Integer>{
+public class Adder implements BinaryOperator<Integer>{
```
Para demostrar a melhoria. Criei umas streams básicas.
Por exemplo, você consegue fazer fatorial com 1 linha de código sem nem precisar implementar nada, já basico da linguagem. 
A minha implementação poderia ser substituida por uma lambda expression facilmente como demonstrado na FunctionSnippet
```java
public void demo_streamOperations() {
    int simpleSomatory = IntStream.rangeClosed(1, 10).reduce(Adder::sum).getAsInt();
        System.out.printf("Simple Sommatory Demo: %d\n", simpleSomatory);
        
        int simpleNegativeSomatory = IntStream.rangeClosed(1, 10).reduce(Reducer::diff).getAsInt();
        System.out.printf("Simple Negative Somatory Demo: %d\n", simpleNegativeSomatory);
        
        int simpleFactorial = IntStream.rangeClosed(1, 10).reduce(Multiplier::x).getAsInt();
        System.out.printf("Simple Factorial Demo: %d\n", simpleFactorial);
        
        int simpleFractionProgression = IntStream.rangeClosed(1, 10).reduce(Divider::divide).getAsInt();
        System.out.printf("Simple Fraction Demo: %d\n", simpleFractionProgression);
}
```
Link do Diff e da atualização completa.
https://github.com/disparter/java-snippets/pull/10/files

#### SpeedTestSnippet

https://link.medium.com/I5MnDiTOmfb

Seguindo esse brilhante artigo, decidi fazer uma comparação com o Java também.
Criei a SpeedTestSnippet e o SpeedTestCliSnippet
O propósito dessas snippets é para testar velocidade, brincando com Stream, Stream Paralelo e um diretão.

Algumas operações não são muito interessantes com paralelismo, pois acaba tendo dificuldade em paralelizar ou então, forçar a propria paralelização pode ser menos eficiente do que o que já tem na JVM.

```bash
SIMPLE FOR SPEED TEST with Length[1000000], took 3ms
STREAM CONSUMER SPEED TEST with Length[1000000], took 7ms
PARALLEL STREAM CONSUMER SPEED TEST with Length[1000000], took 6ms
```
Esse foi o resultado, experimente fazer algumas modificações. Por exemplo, comentar a invocação para os primeiros métodos de speed antes de invocar o paralelo.




