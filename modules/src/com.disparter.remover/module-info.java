import java.util.function.Predicate;

import com.disparter.remover.RemoverSnippet;

module com.disparter.remover {
	requires java.base;
	provides Predicate with RemoverSnippet;
}