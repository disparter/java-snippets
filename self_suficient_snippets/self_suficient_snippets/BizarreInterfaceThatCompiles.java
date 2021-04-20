package self_suficient_snippets;
 
interface BizarreInterfaceThatCompiles {
    void m1();
 
    interface I2 { 
        void m2();
    }
 
    abstract class A1 { 
        public abstract void m3();
    }
 
    public class A2 { 
        public void m4() {
            System.out.println(4);
        }
        public static void main(String[] args) {
			new A2().m4();
		}
    }
}