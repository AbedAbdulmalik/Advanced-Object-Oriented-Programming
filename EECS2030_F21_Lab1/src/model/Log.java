package model;

public class Log {
	private String VersionNum;
	private int numOfFixes;
	private String addedFix = "";
	private final int MAX_NOF = 10;
	private String fix2;
	

	
	
	public Log(String version) {
		VersionNum = version;
	}

	public Log() {
		
	}

	public void setVersion(String version) {
		VersionNum = version;
	}
	
	public String getVersion() {
		
		return VersionNum;
	}

	public int getNumberOfFixes() {
		return numOfFixes;
	}

	public String getFixes() {
		if(addedFix == (null)) {
			addedFix = "";
		}
		
		
		
		return "[" + addedFix + "]";
	}

	public void addFix(String newFixDescription) {
		if ((numOfFixes < MAX_NOF) && numOfFixes == 0) {
			addedFix += newFixDescription;
		}
		
		if ((numOfFixes < MAX_NOF) && numOfFixes != 0) {
			addedFix += ", " + newFixDescription;
		}
		
		numOfFixes ++;
	}
	
	
	
	public String toString() {
		String s = "";
	
		StringBuilder sb = new StringBuilder();
		sb.append("Version " + VersionNum + " contains " + numOfFixes + " fixes " + getFixes());
		
		s = sb.toString();
		
		return s;
	}

}
