package model;

public class Entry {
	
	private String serialNumber; //e.g, U8G4H9L0CY7
	private Product product; //the type of attribute is a reference type, denoting an existing class
							 //At runtime, this attribute will store the address of some Product object.
	
	
	public Entry(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	//An overloaded version of the setProduct mutator
	//This version of setProduct does not expect the user to create a Product object and pass it as an argument, instead we would expect the user to
	//pass a String model and a value of the original price.
	
	public void setProduct(String model, double originalPrice) {
		//this.product = new Product(model, originalPrice);
		Product p = new Product(model, originalPrice);
		this.product = p;
	}
	
	public String toString() {
		return "[" + serialNumber + "] " + this.product.toString();
		
	}
	
	
	
	
}


