package model;

public class AppStore {
	private String branch;
	private int noa;
	private App [] app = new App[100];
	private App appR;
	String placeholder = " versions; Current Version: ";
	
	
	
	public AppStore(String branchName, int maxNumOfApps) {
		branch = branchName;
	}

	public String getBranch() {
		
		return branch;
	}

	public App getApp(String appName) {
		int index = -1;
		for (int i = 0; i < this.noa; i++) {
			App e = this.app[i];
				if(e.getName().equals(appName)) {
					index = i;
				}
		}
		if (index < 0) {
			return null;
		}
		else {
			return app[index];
		}
		
	}

	public App getAppM() {
		return appR;
	}
	
	
	public String[] getStableApps(int stableApps) {
			
//		String[] appsArray = new String[noa];
//		return appsArray;
		int num = 0;
		for(int i =0; i < noa; i++) {
			if(app[i].getUpdateHistory().length >= stableApps) {
				num++;
			}}
		String[] appsArray = new String[num];
		int index =0;
		for(int i =0; i< noa; i++) {
			if(app[i].getUpdateHistory().length > stableApps || app[i].getUpdateHistory().length == stableApps) {
				int appArrayLnegth = app[i].getUpdateHistory().length;
				int temp = app[i].getUpdateHistory().length-1;
				appsArray[index] = app[i].getName() + " (" + appArrayLnegth + placeholder + app[i].getUpdateHistory()[temp].toString() + ")";
				index++;
				}}
		return appsArray;
	}

	public void addApp(App app1) {
		this.app[this.noa] = app1;
		this.noa ++;
		
	}

}
