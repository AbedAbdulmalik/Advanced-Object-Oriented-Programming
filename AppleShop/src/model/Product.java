package model;

public class Product {
	/* attributes*/
	private String model;
	private String finish;
	private int storage;
	private boolean hasCellularConnectivity; //false= has only wifi. truse= has both
	private double originalPrice;
	private double discountValue;
	
	/* constructors */
	public Product() {
		//do nothing: all attributes will be stored in their default values
	}
	
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice;
	}
	/* accessor */
	public String getModel() {
		return model;
	}
	/* mutators */
	 
	

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public boolean hasCellularConnectivity() {
		return hasCellularConnectivity;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double getPrice() {
		//local variable declaration
		 double price = 0.0;
		 
		//computation
		price = originalPrice - discountValue;
		 
		//return
		 return price;
	}
	
	public String toString() {
		String s = "";
		
		StringBuilder sb = new StringBuilder();
		sb.append(model + " " + finish + " " + storage + "GB " + "(cellular connectivity: " + hasCellularConnectivity + "): $(" + String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")");
		
		s = sb.toString();
		
//		s += model + " " + finish + " " + storage + "GB " + "(ceullular connectivity: " + hasCellularConnectivity + "): $(" + String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")";
		
		return s;
	}
}
