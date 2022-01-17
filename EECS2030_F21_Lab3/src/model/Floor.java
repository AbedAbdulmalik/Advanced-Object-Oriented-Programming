package model;

public class Floor {
private double utilSpace;
private int maxSpace;
private int numberOfUnits;
private Unit[] rooms;
	public Floor(int max) {
		utilSpace = 0;
		maxSpace = max;
		rooms = new Unit[20];
	}

	public String toString() {
		String finalString = "Floor's utilized space is " + ((int)this.utilSpace) + " sq ft (" + ((int)(maxSpace - utilSpace)) + " sq ft remaining): [";
		for(int i = 0; i<this.numberOfUnits;i++) {
			finalString = finalString + rooms[i].getNameOfUnit() + ": " + ((int)(rooms[i].getLength()*rooms[i].getWidth())) + " sq ft (" + ((int)this.rooms[i].getWidth()) + "' by " + ((int)this.rooms[i].getLength()) + "')";
			if(i<numberOfUnits-1) {finalString = finalString+", ";}
		}
		return finalString + "]";
	}
	
	

	public void addUnit(String name, int width, int length) throws InsufficientFloorSpaceException {
		if (((width*length) + utilSpace) <= maxSpace) {
		rooms[this.numberOfUnits] = new Unit(name, width, length);
		utilSpace = utilSpace + (rooms[this.numberOfUnits].getLength()* rooms[this.numberOfUnits].getWidth());
		numberOfUnits++;
		}else {
			throw new InsufficientFloorSpaceException();
		}
	}
	
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) { return false; }
		Floor other = (Floor) obj;
		boolean unitBoolean = true;
		for(int i = 0; i < numberOfUnits && unitBoolean ;) {
			for(int counter2 = 0; counter2<other.numberOfUnits;counter2++) {
				if(this.rooms[i].getNameOfUnit() == other.rooms[counter2].getNameOfUnit() && ((this.rooms[i].getLength() * this.rooms[i].getWidth()) == (other.rooms[counter2].getLength()*other.rooms[counter2].getWidth()))) {break;}
				if(counter2 == other.numberOfUnits-1) {
					boolean notSameArea = !(((rooms[counter2].getLength()*rooms[counter2].getWidth())) == ((other.rooms[counter2].getLength()*other.rooms[counter2].getWidth())))|| rooms[i].getNameOfUnit() != other.rooms[counter2].getNameOfUnit();
					if((counter2 == other.numberOfUnits-1 && (notSameArea))) {unitBoolean = false;}}}i++;}
		if(this.numberOfUnits != other.numberOfUnits) {unitBoolean = false;}
		
		return
		(maxSpace) == (other.maxSpace) 
		&& unitBoolean;
		 
	}
	
	
	public Floor(Floor objFloor) {
		rooms = new Unit[20]; maxSpace = objFloor.maxSpace; utilSpace = objFloor.utilSpace;
		numberOfUnits = objFloor.numberOfUnits;
		for(int count = 0;count < objFloor.numberOfUnits;) {rooms[count] = new Unit(objFloor.rooms[count]);count++;}
	}

}
