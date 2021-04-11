package self_suficient_snippets;

import java.util.Random;

public class SpeedTestSnippet {

	private final static int LENGTH = 1000000;
	
	public static void main(String[] args) {
		
		long[] rand_array = new long[LENGTH];
		double[] output = new double[LENGTH];
		
		Random rand = new Random();
		for (int i = 0; i < LENGTH; i++) {
			rand_array[i] = rand.nextLong();
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < LENGTH; i++) {
			output[i] = 1.0 / rand_array[i];
		}
		long end = System.currentTimeMillis();
		System.out.printf("STATIC LENGTH STRAIGHT SPEED %d\n", end - start);
	}

}
