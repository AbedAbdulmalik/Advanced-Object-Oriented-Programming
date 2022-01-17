package model;

public class Unit {
private double width;
private double length;
private String roomName;
private int oddFeetEvenMeterCounter;
private String measurement;
private String measurement2;
private String temp;

	public Unit(String name, double width2, double length2) {
		roomName =  name;
		this.width = width2;
		this.length = length2;
		measurement = "feet";
		measurement2 = "'";
	}
	
	public Unit(Unit objUnit) {
		this.roomName = objUnit.roomName;
		this.width = objUnit.width;
		this.length = objUnit.length;
	}
	
	public void toogleMeasurement() {
		if (this.oddFeetEvenMeterCounter%2 == 0 ) {
			this.width = this.width/3.28;
			this.length = this.length/3.28;
			measurement = "meters";
			measurement2 = " m";
		}else {
			this.width = this.width*3.281;
			this.length = this.length*3.281;
			measurement = "feet";
			measurement2 = "'";
		}
		oddFeetEvenMeterCounter++;
		
	}
	
	public double getWidth() {return (int)width;}
	public double getLength() {return (int)length;}
	public String getNameOfUnit() {return roomName;}
	public String toString() {
		String s = "";
	
		StringBuilder sb = new StringBuilder();
		if (this.measurement.equals("feet") ) {
			sb.append("A unit of "+String.format("%.0f", (this.width*this.length))+" square feet ("+String.format("%.0f", width) + "'"+" wide and "+String.format("%.0f", length) +"'"+" long) functioning as " + roomName);
		}else if(this.measurement.equals("meters") ) {
			sb.append("A unit of "+String.format("%.2f", (this.width*this.length))+" square meters ("+String.format("%.2f", width) + " m"+" wide and "+String.format("%.2f", length) + " m"+" long) functioning as " + roomName);
		}
		
		
		s = sb.toString();
		
		return s;
	}
	
	
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) { return false; }
		Unit other = (Unit) obj;
		if(!(this.roomName.equals(other.roomName))) {return false;}
		return
		(this.width*this.length) == other.width*other.length;
		 }
}
