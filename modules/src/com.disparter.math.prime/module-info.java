import java.util.function.Function;

import com.disparter.math.prime.PrimeChecker;

module com.disparter.math {
	requires java.base;
	provides Function with PrimeChecker;
	exports com.disparter.math.prime;
}