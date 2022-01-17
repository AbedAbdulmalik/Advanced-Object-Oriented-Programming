package model;

public class VaccinationSite {
private String location;
private Vaccine vax;
private String vaccineArray[];
private Vaccine vax2[];
private int MD;
private int PD;
private int OD;
private int JD;
private int TD;
private int TD2;
private int nov;
private int doseLimit;
private String newAppointment;
private HealthRecord hr;
private int noad;
private int noadd;
private int tempVar;
private HealthRecord apps[];
	public VaccinationSite(String location, int limit) {
		this.location = location;
		vaccineArray = new String[0];
		apps = new HealthRecord[200];
		doseLimit = limit;
		vax2 = new Vaccine[doseLimit];
	}
	public String getLocation() {
		return location;
	}
	public int getNumberOfAvailableDoses() {
		noad = MD + PD + JD + OD;
		return noad;
	}

	public int getNumberOfAvailableDoses(String type) {
		if(type == "mRNA-1273") {
			return MD;
		}
		if(type == "BNT162b2") {
			return PD;
		}
		if(type == "Ad26.COV2.S") {
			return JD;
		}
		else {
			return OD;
		}
		
	}

	
	public String toString() {
		String s = "";
		s = "";
		
		for(int i =0;i<TD; i++) {
			
			s = s +(this.getNumberOfAvailableDoses(vax2[i].getCodeName()) + " doses of " + vax2[i].getManuFacturer());
			if(i < TD-1) {
				s = s + ", ";
			}
		}
		return location + " has " +nov + " available doses: <" + s+ ">";
	}

	public void addDistribution (Vaccine vaxx, int numberOfShots) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException {
		String v = vaxx.getCodeName();
		int x = nov+numberOfShots;
		if(!(vaxx.getCodeName().equals("Ad26.COV2.S")) && !(vaxx.getCodeName().equals("AZD1222")) &&
		   !(vaxx.getCodeName().equals("mRNA-1273")) && !(vaxx.getCodeName().equals("BNT162b2"))) {
			throw new UnrecognizedVaccineCodeNameException("name is " + v);
		}
		
		if(x>doseLimit) {throw new TooMuchDistributionException("name is " + nov);}
		int i =0;
		int counter= -1;
		boolean booleanT = true;
		for (;booleanT && i<TD; i++) {
			if(vax2[i] == vaxx) {booleanT = false;}
		}
		if(!booleanT) {counter = i-1;}
		else {
			counter = TD;
			vax2[TD] = vaxx;
			TD++;
		}
		if(vax2[counter].getCodeName().equals("BNT162b2")) {PD+=numberOfShots;}
		else if(vax2[counter].getCodeName().equals("mRNA-1273")) {MD+=numberOfShots;}
		else if(vax2[counter].getCodeName().equals("AZD1222")) {OD+=numberOfShots;}
		else if(vax2[counter].getCodeName().equals("Ad26.COV2.S")) {JD+=numberOfShots;}
		nov= nov+ numberOfShots;
	}
	
	public void bookAppointment(HealthRecord recordObject) throws InsufficientVaccineDosesException{
		if(noadd >= getNumberOfAvailableDoses()) {
			throw new InsufficientVaccineDosesException(recordObject, location);
		}else {
			
		}
		noadd++;
		recordObject.setStatus("Last vaccination appointment for " + recordObject.returnName() + " with " + location + " succeeded");
	
	}

	public void administer(String string) {
		// TODO Auto-generated method stub
		
	}
}
