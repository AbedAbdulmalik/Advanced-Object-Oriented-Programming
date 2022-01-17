package model;

public class InsufficientVaccineDosesException extends Exception {
HealthRecord temp;
	public InsufficientVaccineDosesException(HealthRecord recordObject, String location) {
		temp = recordObject;
		temp.setStatus("Last vaccination appointment for "+temp.returnName()+" with "+location+" failed");
	}

}
