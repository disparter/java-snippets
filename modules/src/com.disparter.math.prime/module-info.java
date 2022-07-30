import java.util.function.Function;

import com.disparter.math.prime.PrimeChecker;
import com.disparter.math.prime.PrimeCheckerWithDivisorsList;
import com.disparter.math.prime.PrimeDivisors;

module com.disparter.math.prime {
	requires java.base;
	provides Function with PrimeChecker, PrimeCheckerWithDivisorsList, PrimeDivisors;
	exports com.disparter.math.prime;
}