package model;

public class VaccineDistribution {
private int numOfDoses;
private Vaccine vax;
	public VaccineDistribution(Vaccine vax, int doseAmount) {
		this.vax = vax;
		numOfDoses = doseAmount;
	}
	
	
	public String toString() {
		String s = "";
	
		StringBuilder sb = new StringBuilder();
			sb.append(numOfDoses+ " doses of " +vax.getCodeName()+ " by "+ vax.getManuFacturer());
		
		
		s = sb.toString();
		
		return s;
	}

}
