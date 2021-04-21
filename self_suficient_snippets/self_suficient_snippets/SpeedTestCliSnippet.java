package self_suficient_snippets;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class SpeedTestCliSnippet {

	private final static int LENGTH = 1000000;
	
	public static void main(String[] args) {
	
		int length = LENGTH;
		if(args.length > 0){
			System.out.printf("Changing Default Length (%d), To (%s)\n", LENGTH, args[0]);
			length = Integer.parseInt(args[0]);
		}

		runStraight(length);
		runStreams(length);
		runParallelStreams(length);
	}

	private static void runStraight(final int length){
		long[] rand_array = new long[length];
		double[] output = new double[length];
		
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			rand_array[i] = rand.nextLong();
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			output[i] = 1.0 / rand_array[i];
		}
		long end = System.currentTimeMillis();
		System.out.printf("SIMPLE FOR SPEED TEST with Length[%d], took %dms\n", length, end - start);
	}

	private static void runStreams(final int length){
		long[] rand_array = new long[length];
		double[] output = new double[length];
		
		Random rand = new Random();
		
		IntConsumer allocate = x -> rand_array[x] = rand.nextLong();
		IntConsumer allocateDoubles = x -> output[x] = 1.0 / rand_array[x];
		
		IntStream.rangeClosed(0, length-1).forEach(allocate);
		long start = System.currentTimeMillis();
		IntStream.rangeClosed(0, length-1).forEach(allocateDoubles);
		long end = System.currentTimeMillis();

		System.out.printf("STREAM CONSUMER SPEED TEST with Length[%d], took %dms\n", length, end - start);
	}

	private static void runParallelStreams(final int length){
		final int parallelism = 4;
		long[] rand_array = new long[length];
		double[] output = new double[length];
		
		Random rand = new Random();
		
		IntConsumer allocate = x -> rand_array[x] = rand.nextLong();
		IntStream stream = IntStream.rangeClosed(0, length-1);
		stream.parallel().forEach(allocate);
		final long[] input = rand_array;

		IntConsumer allocateDoubles = (int x) -> output[x] = 1.0 / input[x];

		ForkJoinPool customThreadPool = null;
		try {
			customThreadPool = new ForkJoinPool(parallelism);
			var task = customThreadPool.submit(() -> IntStream
			    .rangeClosed(0, length-1)
				.parallel().forEach(allocateDoubles));

			long start = System.currentTimeMillis();
			task.join();
			long end = System.currentTimeMillis();
			System.out.printf("PARALLEL STREAM CONSUMER SPEED TEST with Length[%d], took %dms\n", length, end - start);
		} finally {
			if (customThreadPool != null) {
				customThreadPool.shutdown();
			}
		}

	}


}
