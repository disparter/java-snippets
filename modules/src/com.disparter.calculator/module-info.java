import java.util.function.BiFunction;

import com.disparter.calculator.Adder;
import com.disparter.calculator.Divider;
import com.disparter.calculator.Multiplier;
import com.disparter.calculator.Reducer;

module com.disparter.calculator {
	requires java.base;
	provides BiFunction with Adder, Multiplier, Reducer, Divider;

}