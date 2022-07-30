import java.util.function.Function;

import com.disparter.math.prime.PrimeChecker;

module com.disparter.math.prime {
	requires java.base;
	provides Function with PrimeChecker;
	exports com.disparter.math.prime;
}