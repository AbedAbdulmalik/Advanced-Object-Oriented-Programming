package model;

public class Vaccine {
private String codeName;
private String type;
private String manuFacturer;
	public Vaccine(String codename, String type, String manufacturer) {
		codeName = codename;
		this.type = type;
		manuFacturer = manufacturer;
	}
	
	public String getManuFacturer() {
		return manuFacturer;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getCodeName() {
		return codeName;
	}
	
	public String toString() {
		String s = "";
	
		StringBuilder sb = new StringBuilder();
		if(codeName == "mRNA-1273" || codeName == "BNT162b2" || codeName == "Ad26.COV2.S" || codeName == "AZD1222") {
			sb.append("Recognized vaccine: " + codeName+ " ("+this.type+"; " + manuFacturer+")");
		}else {
			sb.append("Unrecognized vaccine: " + codeName+ " ("+this.type+"; " + manuFacturer+")");
		}
		
		s = sb.toString();
		
		return s;
	}

}
