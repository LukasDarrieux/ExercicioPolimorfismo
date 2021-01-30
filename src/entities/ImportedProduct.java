package entities;

public class ImportedProduct extends Product {
	
	private double customsFee;

	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $ " + String.format("%.2f", this.totalPrice()) + " (Customs fee: $ " + String.format("%.2f", this.customsFee) + ")";
	}
	
	public double totalPrice() {
		return getPrice() + this.customsFee;
	}
	
}
