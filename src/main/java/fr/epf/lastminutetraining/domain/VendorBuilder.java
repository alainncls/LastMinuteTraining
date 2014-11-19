// CHECKSTYLE:OFF
/**
 * Source code generated by Fluent Builders Generator
 * Do not modify this file
 * See generator home page at: http://code.google.com/p/fluent-builders-generator-eclipse-plugin/
 */

package fr.epf.lastminutetraining.domain;

import org.bson.types.ObjectId;

public class VendorBuilder extends VendorBuilderBase<VendorBuilder> {
	public static VendorBuilder vendor() {
		return new VendorBuilder();
	}

	public VendorBuilder() {
		super(new Vendor());
	}

	public Vendor build() {
		return getInstance();
	}
}

class VendorBuilderBase<GeneratorT extends VendorBuilderBase<GeneratorT>> {
	private Vendor instance;

	protected VendorBuilderBase(Vendor aInstance) {
		instance = aInstance;
	}

	protected Vendor getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT name(String aValue) {
		instance.setName(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT avatar(String aValue) {
		instance.setAvatar(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT margin(String aValue) {
		instance.setMargin(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT sub(String aValue) {
		instance.setSub(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT cP(String aValue) {
		instance.setCp(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT iban(String aValue) {
		instance.setIban(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT id(ObjectId aValue) {
		instance.setId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT firstName(String aValue) {
		instance.setFirstName(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT lastName(String aValue) {
		instance.setLastName(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT address(String aValue) {
		instance.setAddress(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT town(String aValue) {
		instance.setTown(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT cp(String aValue) {
		instance.setCp(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT mail(String aValue) {
		instance.setMail(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT phone(String aValue) {
		instance.setPhone(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT login(String aValue) {
		instance.setLogin(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT password(String aValue) {
		instance.setPassword(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT bank(String aValue) {
		instance.setBank(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT cardNumber(String aValue) {
		instance.setCardNumber(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT expirationDate(String aValue) {
		instance.setExpirationDate(aValue);

		return (GeneratorT) this;
	}
}
