package self_suficient_snippets;
 
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;
 
public class MultiThreadSummerSnippet {
	
    private static long LIMIT = 1000000000;
    private static final int THREADS = 100;
 
    private static class SummerTask extends RecursiveTask<Long> {
        private static final long serialVersionUID = 7085960334032177809L;
		long from, to;
 
        public SummerTask(long from, long to) {
            this.from = from;
            this.to = to;
        }
 
        @Override
        protected Long compute() {
            if ((to - from) <= LIMIT/THREADS) {
                long localSum = 0;
                for(long i = from; i <= to; i++) {
                    localSum += i;
                }
                return localSum;
            }
            else {
                long mid = (from + to) / 2;
                SummerTask first = new SummerTask(from, mid);
                SummerTask second = new SummerTask(mid + 1, to);
                first.fork();
                return second.compute() + first.join();
            }
        }
    }
 
    public static void main(String[] args) {
        
        final var streamStartTime = System.currentTimeMillis();
        final long streamSum = LongStream.rangeClosed(1, LIMIT).sum();
        final var streamElapsedTime = System.currentTimeMillis() - streamStartTime;
        System.out.printf("Stream Sum from %d to %d is %d, time passed [%d]\n", 1, LIMIT, streamSum, streamElapsedTime);

        
        final var pStreamStartTime = System.currentTimeMillis();
        final long pStreamSum = LongStream.rangeClosed(1, LIMIT).parallel().sum();
        final var pStreamElapsedTime = System.currentTimeMillis() - pStreamStartTime;
        System.out.printf("Parallel Stream Sum from %d to %d is %d, time passed [%d]\n", 1, LIMIT, pStreamSum, pStreamElapsedTime);

        ForkJoinPool pool = new ForkJoinPool(THREADS);
        
        final var threadStartTime = System.currentTimeMillis();
        final long threadSum = pool.invoke(new SummerTask(1, LIMIT));
        final var threadElapsedTime = System.currentTimeMillis() - threadStartTime;
        System.out.printf("Parallel Thread sum from %d to %d is %d, time passed [%d]\n", 1, LIMIT, threadSum, threadElapsedTime);
       
        
    }
}