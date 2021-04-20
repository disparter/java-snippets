package self_suficient_snippets;
 
class Outer {
    public static void printHello() {}
    static {
        class Inner {
            {
            	System.out.println("HELLO");
            }
        }
        new Inner();
    }
}
 
public class ScopeAndBlockExecution {
    public static void main(String[] args) {
        Outer.printHello();
    }
}