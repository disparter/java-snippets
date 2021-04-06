import java.util.function.Consumer;

import com.disparter.consumer.SysoutPrinterConsumerSnippet;

module com.disparter.consumer {
	requires java.base;
	provides Consumer with SysoutPrinterConsumerSnippet;
	exports com.disparter.consumer;
}