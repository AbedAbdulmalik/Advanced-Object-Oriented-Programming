package model;

public class Subscriber extends Follower {
	protected int numberOfCs; protected int maxNumOfChannels;
	protected Channel[] channels; protected String[] RecsArray;
	protected int maxNumOfRec; protected int numberOfRecs;
	
	public Subscriber(String name, int maxChannels, int Recs) {
		numberOfCs = 0;followerName = name;
		numberOfRecs = 0;Followertype = "Subscriber";
		maxNumOfRec = Recs;maxNumOfChannels = maxChannels;
		channels = new Channel[maxNumOfChannels];RecsArray = new String[maxNumOfRec];
	}
	
	public void watch(String name, int time) {
		int i = 0;
		while(i<this.numberOfCs) {
			if(!(this.channels[i].getVideo(name)).equals("noDetail")) {this.channels[i].updateStats(name, time);break;}i++;}
	}
	
	protected void addChannel(Channel channelName) {channels[numberOfCs] = channelName;numberOfCs++;}
	protected void addRecommendation(String newRecommendation) {RecsArray[numberOfRecs] = newRecommendation;numberOfRecs++;}
	
	public String toString() {
		if(numberOfRecs == 0 && numberOfCs == 0) {
			return Followertype + " " + followerName + " follows no channels and has no recommended videos.";
		}
		String strfinal = "";String str1 = "[";String str2 = "<";
		if(!(numberOfRecs != 0)) {
			for(int i = 0; i< numberOfCs; i++) {str1 = str1+ channels[i].nameOfPerson; if(i+1<numberOfCs) {str1 = str1+ ", ";}}
			str1= str1 + "]";
			return Followertype + " " + followerName + " follows " + str1 + " and has no recommended videos.";
		}
		
		for(int i = 0; i< numberOfCs; i++) {str1 = str1+ this.channels[i].nameOfPerson; if(i<numberOfCs-1) {str1 = str1 +", ";}}
		
		for(int i = 0; i< this.numberOfRecs; i++) {
			str2 = str2 + RecsArray[i];
			if(i+1<numberOfRecs) {
				str2 = str2 + ", ";
			}
		}
		str1= str1 +"]";
		str2= str2 +">";
		strfinal = Followertype + " " + followerName + " follows " + str1 + " and is recommended " + str2 + ".";
		return strfinal;
	}
	
	protected void removeChannel(Channel channel) {
		boolean flag = false;
		int x = 0;
		for(int i =0;!flag && i < numberOfCs;i++) {
			if(this.channels[i].equals(channel)) {flag = true;numberOfCs = numberOfCs -1;x = i;}
		}	
		if(flag) {
			Channel[] newC = new Channel[this.numberOfCs];
	        for (int i = 0, k = 0; i < this.numberOfCs+1;) {if (i != x) {newC[k++] = this.channels[i];} i++;}
	        channels = new Channel[maxNumOfChannels];
			for(int i = 0; i < numberOfCs;) {channels[i] = newC[i]; i++;}}
	}
}
