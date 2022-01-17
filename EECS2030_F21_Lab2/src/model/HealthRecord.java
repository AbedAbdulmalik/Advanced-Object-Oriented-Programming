package model;

public class HealthRecord {
private String personName;
private int doseLimit;
private String vaxReceipt;
private String appStatus;
private int nov;
private Vaccine vax;
private Vaccine vax2;
private String location;
private String location2;
private String date;
private String date2;
private int app;
private boolean fail;
private VaccinationSite vs;
	public HealthRecord(String name, int doseLimit) {
		this.doseLimit = doseLimit;
		personName = name;
		if(app == 0) {
			appStatus = "No vaccination appointment for "+personName+" yet";
		}
		if(app >= 1) {
			appStatus = "Last vaccination appointment for "+personName+" with "+location+" succeeded";
		}
		
		
	}
	public String returnName() {
		return personName;
	}
	public void addAppointment() {
		app++;
	}
	public String getVaccinationReceipt() {
		if (nov == 0) {
			vaxReceipt = personName + " has not yet received any doses.";
		}else if(nov == 1) {
			vaxReceipt = "Number of doses "+personName+" has received: "+nov+" ["+vax.toString()+" in " + location+" on "+date+"]";
		}else if(nov == 2) {
			vaxReceipt = "Number of doses "+personName+" has received: "+nov+" ["+vax.toString()+" in " + location+" on "+date+"; "+vax2.toString()+" in " + this.location2+" on "+this.date2+"]";
		}
		
		return vaxReceipt;
	}
	public void setStatus(String string) {
		appStatus = string;
	}
	public String getAppointmentStatus() {
		return appStatus;
	}
	public void addRecord(Vaccine vax, String location, String date) {
		if(nov== 0) {
			this.vax = vax;
			this.location = location;
			this.date = date;
			nov++;
		}
		else if(nov== 1) {
			this.vax2 = vax;
			this.location2 = location;
			this.date2 = date;
			nov++;
		}
	}
	public void fail() {
		app = -1;
	}

}
