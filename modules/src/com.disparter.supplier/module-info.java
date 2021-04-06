import java.util.function.Supplier;

import com.disparter.supplier.RandomSupplierSnippet;

module com.disparter.supplier {
	requires java.base;
	provides Supplier with RandomSupplierSnippet;
	exports com.disparter.supplier;
}