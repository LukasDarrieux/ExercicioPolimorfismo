package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private SimpleDateFormat sdf;
	private Date manufactureDate;

	public UsedProduct() {
		
	}

	public UsedProduct(String name, double price, Date manufactureDate) {
		super(name, price);
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return this.getName() + " (used) $ " + String.format("%.2f", this.getPrice()) + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}
}
