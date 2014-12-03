// CHECKSTYLE:OFF
/**
 * Source code generated by Fluent Builders Generator
 * Do not modify this file
 * See generator home page at: http://code.google.com/p/fluent-builders-generator-eclipse-plugin/
 */

package fr.epf.lastminutetraining.domain;

public class OrderBuilder extends OrderBuilderBase<OrderBuilder> {
	public static OrderBuilder order() {
		return new OrderBuilder();
	}

	public OrderBuilder() {
		super(new Order());
	}

	public Order build() {
		return getInstance();
	}
}

class OrderBuilderBase<GeneratorT extends OrderBuilderBase<GeneratorT>> {
	private Order instance;

	protected OrderBuilderBase(Order aInstance) {
		instance = aInstance;
	}

	protected Order getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT training(Training aValue) {
		instance.setTraining(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT quantity(Integer aValue) {
		instance.setQuantity(aValue);

		return (GeneratorT) this;
	}
}
