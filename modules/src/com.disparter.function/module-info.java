import java.util.function.Function;

import com.disparter.function.SquaredFunction;

module com.disparter.function {
	requires java.base;
	provides Function with SquaredFunction;
	exports com.disparter.function;
}