package model;

public class Account {
	private AppStore appstoreR;
	private String nameOfPerson;
	private int noda;
	private String returnS;
	private App[] app;
	private App appR;
	private final int MAX_CAPACITY = 50;
	
	public App getAppM() {
		return appR;
	}
	
	public AppStore getAppStoreM() {
		return appstoreR;
	}

	public Account(String userName, AppStore linkedStore) {
		nameOfPerson = userName;
		appstoreR = linkedStore;
		returnS = ("An account linked to the " + appstoreR.getBranch() + " store is created for " + nameOfPerson + ".");
		app = new App[MAX_CAPACITY];
		noda = 0;
		
	}

	
	public String toString() {
		return returnS;
	}

	public App[] getEntries() { //Retrieve the array of entries in the chronological order in which they were inserted
		App[] es = new App[this.noda];
		for(int i = 0; i < this.noda; i++) {
			es[i] = this.app[i];
		}
		return es;
	}
	
	public String[] getNamesOfDownloadedApps() {
//		String[] numberOfDownloadedApps = new String[noda];
//		return numberOfDownloadedApps;
		String[] NamesOfDownloadedApps = new String[noda];
		  for(int i = 0; i < this.noda; i ++) {
			  if(this.app != null) {
			  NamesOfDownloadedApps[i] = this.app[i].getName();}
	            } 
		return NamesOfDownloadedApps;
	}
		
	

	public App[] getObjectsOfDownloadedApps() {
//		App[] objectsOfDownloadedApps = new App[noda];
//		return objectsOfDownloadedApps;
		
		App[] UpdateHistory = new App[this.noda];
		  for(int i = 0; i < this.noda; i ++) {
			 
	            UpdateHistory[i] = app[i];}
	            
		return UpdateHistory;
	}

	public void uninstall(String appName) {
		boolean appIsFound = false;
		for (int i = 0; i < this.noda && appIsFound == false; i ++) {
			if(getNamesOfDownloadedApps()[i].equals(appName)) {
				appIsFound = true;
			}else {
				appIsFound = false;
			}
			
		}
		if(appIsFound == false ) {
			returnS = "Error: " + appName +" has not been downloaded for "+ nameOfPerson +".";
		}else {
			returnS = appName + " is successfully uninstalled for "+ nameOfPerson +".";
			noda--;
			App[] tempAppsArray = new App[noda];
			for (int i = 0; i < this.noda ; i ++) {
				if(!(app[i].getName().equals(appName))) {
					tempAppsArray[i] = app[i];
					}
			}
			
		}
		
		
	}

	public void submitRating(String appName, int rateNum) {
		boolean appIsFound = false;
		for (int i = 0; i < this.noda && appIsFound == false; i ++) {
			if(getNamesOfDownloadedApps()[i].equals(appName) ) {
				appIsFound = true;
			}else {
				appIsFound = false;
			}
			
		}
		if(appIsFound == false || appstoreR.getApp(appName) == null) {
			returnS = "Error: " + appName +" is not a downloaded app for "+ nameOfPerson +".";
		}else {
			returnS = "Rating score " + rateNum+" of " +nameOfPerson+" is successfully submitted for "+appName +".";
			appstoreR.getApp(appName).submitRating(rateNum);
		}
		
		
	}

	public void switchStore(AppStore newStore) {
		appstoreR = newStore;
		returnS = "Account for " + nameOfPerson +" is now linked to the "+ appstoreR.getBranch() +" store.";
		
	}

	public void download(String name) {
//		returnS = name + " is successfully downloaded for " + nameOfPerson + ".";
//		for(int i =0; i < noda; i++) {
//			app[i] = appsDownloaded[i];
//		}
		
		boolean appFound = false;
		for(int i = 0; i < noda && !appFound== true  ; i++) {
			if(app[i].getName().equals(name)) {
				appFound = true;
				returnS = "Error: " + name+ " has already been downloaded for " + nameOfPerson +".";
			}
			
		}
		if(!appFound == true) {
			returnS = name + " is successfully downloaded for " + nameOfPerson + ".";
			App downloadApp = new App(name,  appstoreR.getApp(name).getMaxRating());
			app[noda] = downloadApp;
			noda++;
		}
		
		
	}
}
