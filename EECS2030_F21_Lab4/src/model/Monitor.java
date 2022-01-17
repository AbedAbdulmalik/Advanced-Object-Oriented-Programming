package model;

public class Monitor extends Follower {
	
	protected Channel[] channelArray; protected int[] viewsArray;
	protected int numberOfChannels; protected int[] timeSpentWatching;
	protected int channelLimit; protected int[] maximumTime;
	protected String[] avgTime;
	

	public Monitor(String Personname, int max) {
		followerName = Personname;Followertype = "Monitor";
		channelLimit = max;
		viewsArray = new int[channelLimit]; maximumTime = new int[channelLimit];
		timeSpentWatching = new int[channelLimit]; avgTime = new String[channelLimit];
		channelArray = new Channel[channelLimit];
	}
	
	protected void updateStats(String name, int time) {
		for (int i = 0; i < this.numberOfChannels; i++) {
			if ((this.channelArray[i].getVideo(name)).equals("detail")) {viewsArray[i]++; timeSpentWatching[i] = timeSpentWatching[i] + time;
				if (time > maximumTime[i]) {maximumTime[i] = time;}
				String n = String.format("%.2f", ((double) timeSpentWatching[i] /  viewsArray[i]));
				avgTime[i] = n;
			}}
		}
	
	public String toString() {
		String finalS  = "";
		if (numberOfChannels == 0) {return Followertype + " " + followerName + " follows no channels.";}
		
		String temp = "["; 
		for (int i = 0; i < numberOfChannels; i++) {temp = temp+ channelArray[i].nameOfPerson;
			if (viewsArray[i] > 0) {temp = temp+ " {#views: " + viewsArray[i] + ", max watch time: " + maximumTime[i] + ", avg watch time: "+ avgTime[i] + "}";}
			if (i < numberOfChannels - 1) {temp = temp+ ", ";}
		}
		temp = temp+ "]";
		finalS = Followertype + " " + followerName + " follows " + temp + ".";
		return finalS;
	}
	
	protected void addChannel(Channel channel) {
		channelArray[numberOfChannels] = channel;
		timeSpentWatching[numberOfChannels] = 0;
		viewsArray[numberOfChannels] = 0;
		avgTime[numberOfChannels] = "";
		maximumTime[numberOfChannels] = 0;
		numberOfChannels++;

	}
	
	protected void removeChannel(Channel channel) {
		boolean flag = false;
		int counter2 = 0;
		
		for (int r = 0;!flag && r < numberOfChannels;r++) {
			if (channelArray[r].equals(channel)) {flag = true;numberOfChannels= numberOfChannels-1;
				counter2 = r;
			}
		}

		if (flag) 
		{
			Channel[] newC = new Channel[numberOfChannels];
			int[] newWT = new int[numberOfChannels];
			int[] newV = new int[numberOfChannels];
			String[] newAVG = new String[numberOfChannels];
			int[] newMax = new int[numberOfChannels];

			for (int i = 0, k = 0; i < numberOfChannels + 1; i++) {
				if (i != counter2) {newC[k] = channelArray[i];newWT[k] = timeSpentWatching[i];newV[k] = viewsArray[i];
					newAVG[k] = avgTime[i]; newMax[k] = maximumTime[i];}k++;}

			viewsArray = newV;channelArray = newC;
			maximumTime = newMax;
			avgTime = newAVG;timeSpentWatching = newWT;
		}
	}
}
