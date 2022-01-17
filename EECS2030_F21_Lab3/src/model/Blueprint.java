package model;

public class Blueprint {
	
	private int currentFloor;
	private Floor[] floors;
	private int totalFloors;
	
	
	public Blueprint(int currentFloor) {
		totalFloors = 0;
		this.currentFloor = currentFloor;
		floors = new Floor[this.currentFloor];
		
		
	}

	public Floor[] getFloors() {
		Floor[] floorsArray = new Floor[totalFloors];
		for(int i = 0; i < totalFloors; i++) {
			floorsArray[i] = new Floor(floors[i]);;
		}return floorsArray;
	}
	
	public void addFloorPlan(Floor newPlan) {
		this.floors[totalFloors] = newPlan;
		this.totalFloors++;
	}
	
	public Blueprint(Blueprint objBlueprint) {
		this(objBlueprint.currentFloor);
		this.totalFloors = objBlueprint.totalFloors;
		for(int count = 0;count<objBlueprint.totalFloors;) {
			this.floors[count] = new Floor(objBlueprint.floors[count]);count++;}
	}
	
	public String toString() {
		double newNumOfFloor = totalFloors;
		double percentValue = (newNumOfFloor/currentFloor * 100);
		if(totalFloors >=0) {
			return String.format("%.1f", percentValue) + " percents of building blueprint completed (" + String.format("%.0f", newNumOfFloor) + " out of " + currentFloor + " floors)";
		}
		else {
			return "error";
		}
		
	}
}