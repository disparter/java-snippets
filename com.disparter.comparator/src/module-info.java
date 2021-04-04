import java.util.Comparator;

import com.disparter.comparator.AlphaNoCaseComparatorSnippet;

module com.disparter.comparator {
	requires java.base;
	provides Comparator with AlphaNoCaseComparatorSnippet;
	exports com.disparter.comparator;
}
