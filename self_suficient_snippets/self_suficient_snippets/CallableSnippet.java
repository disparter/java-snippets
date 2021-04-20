package self_suficient_snippets;
 
import java.util.concurrent.*;
 
class MyCallable implements Callable<Integer> {
    private Integer i;
 
    public MyCallable(Integer i) {
        this.i = i;
    }
 
    public Integer call() throws Exception {
        return --i;
    }
}
 
public class CallableSnippet {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var executor = Executors.newSingleThreadExecutor();
        var callable = new MyCallable(1000);
        var future = executor.submit(callable);
        System.out.println(future.get());
        executor.shutdown();
    }
}