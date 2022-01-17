package model;

public class App {
private int nou = 0;
private String appName;
private int ratings;
private String getWhatIsNew = "n/a";
private Log[] log = new Log[10];
private String currentVersion = "n/a";
private int avgRating = 0;
private Log logR = new Log();
private Log update;
private int score1;
private int score2;
private int score3;
private int score4;
private int score5;
private int ratingCount;
private double ratingAvg;
private double totalScore;
private int test;

	public App(String name, int maxNumberOfRatings) {
		appName = name;
		test= maxNumberOfRatings;
		
	}
	
	public int getMaxRating() {
		return test;
	}
	public String getName() {
		
		return appName;
	}

	public Log[] getLogs() {
		return log;
	}
	
	public Log getLog() {
		return logR;
	}
	
	public String getWhatIsNew() {
		if(nou == 0) {
			return "n/a";
		}
		else{
			String temp = ("Version " + currentVersion + " contains " + logR.getNumberOfFixes() + " fixes " + logR.getFixes());
			
			return temp;
		}
		
//		else {
//			return log[nou-1].toString();
//		}
	}

	public Log[] getUpdateHistory() {
		Log[] UpdateHistory = new Log[nou];
		  for(int i = 0; i < this.nou; i ++) {
	            UpdateHistory[i] = log[i];
	            } 
		return UpdateHistory;
	}
	
	public int getNumberOfUpdates() {
		return nou;
		
	}

	public Log getVersionInfo(String versionNumber) {
		  for(int i = 0; i < this.nou; i ++) {
			  if(log[i].getVersion().equals(versionNumber)) {
				  return getUpdateHistory()[i];
			  }
		  }
		  return null;
		
	}

	public String getRatingReport() {
		if(getNumberOfUpdates() == 0 || ratingCount == 0) {
			return "No ratings submitted so far!";
		}else {
			return "Average of " + ratingCount +" ratings: " + String.format("%.1f", ratingAvg)+ " (Score 5: " + score5 + ", Score 4: " + score4 + ", Score 3: " + score3 + ", Score 2: " + score2 + ", Score 1: " + score1 + ")";
			
		}
		
	}


	
	public void releaseUpdate(String newUpdate) {
		currentVersion = newUpdate;
		log[nou] = new Log(newUpdate);
		nou ++;
		
	}
	
	
	public String toString() {
		String s = "";
	
		StringBuilder sb = new StringBuilder();
		if(getRatingReport().equals("No ratings submitted so far!")) {
			sb.append(appName + " (Current Version: " + currentVersion + ";" + " Average Rating: n/a)");
		}else {
			sb.append(appName + " (Current Version: "+ getUpdateHistory()[nou-1].toString() + ";" + " Average Rating: " + String.format("%.1f", ratingAvg) + ")");
		}
		
		s = sb.toString();
		
		return s;
	}

	public void submitRating(int rate) {
		if (rate == 1) {
			score1 ++;
			totalScore += 1;
		}
		if (rate == 2) {
			score2 ++;
			totalScore += 2;
		}
		if (rate == 3) {
			score3 ++;
			totalScore += 3;
		}
		if (rate == 4) {
			score4 ++;
			totalScore += 4;
		}
		if (rate == 5) {
			score5 ++;
			totalScore += 5;
		}
		ratingCount++;
		ratingAvg = (totalScore)/ratingCount;
		
	}

}
