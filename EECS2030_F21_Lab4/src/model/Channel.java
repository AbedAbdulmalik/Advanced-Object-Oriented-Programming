package model;

public class Channel {
	protected Follower[] followers;protected String[] vidsArray;
	protected int maximum;protected int maxVids;protected String nameOfPerson;
	protected int totalViews;protected int follower;
	
	
	public Channel(String name, int maximumF, int maximumV) {
		follower = 0;totalViews = 0;
		maxVids = maximumV;	maximum = maximumF;	this.nameOfPerson = name;
		vidsArray = new String[this.maxVids]; followers = new Follower[this.maximum];}
	
	public void unfollow(Follower person)
	{
		boolean flag = true;
		int counter = 0;
		for(int j = 0;flag && j < follower;) {
			if(this.followers[j].equals(person)) {counter = j;follower = follower -1;flag = false;}
			j++;}
			
		
		if(!(flag))
		{
			Follower[] newArray = new Follower[follower];
			int counter2 = 0;
	        for (int i = 0 ; i < this.follower+1; i++) {if (i != counter) {newArray[counter2++] = this.followers[i];}}
	        followers = new Follower[maximum];
			for(int l = 0; l < this.follower; l++) {followers[l] = newArray[l];}
		}
		person.removeChannel(this);
	}
	
	public String getVideo(String video) {
		int i = 0;
		for(; i < this.totalViews;) {
			if(this.vidsArray[i].equals(video)) {return "detail";}
			 i++;}
												 return "noDetail";}
	
	public void releaseANewVideo(String videoName) {
		vidsArray[this.totalViews] = videoName;totalViews = totalViews +1; int i = 0;
		for(; i<this.follower;) {this.followers[i].addRecommendation(videoName);i++;}
	}
	
	

	
	public void updateStats(String name, int timeInMinutes) 
	{
		for(int i =0; i< follower;) {
			if(!(Monitor.class.isInstance(followers[i]))) {}
			else {Monitor track = (Monitor) followers[i]; track.updateStats(name, timeInMinutes);}i++;}
	}

	public String toString() {
		if(follower == 0 && totalViews == 0) {return nameOfPerson + " released no videos and has no followers.";}
		
		String newFollower = "[";	String vid = "<";
		if(totalViews == 0) {
			for(int i = 0; i < follower; i++) {
				newFollower = newFollower + followers[i].Followertype + " " + followers[i].followerName;
				if(i+1<this.follower) {newFollower= newFollower +", ";}
			}
			newFollower=newFollower+"]";
			return (nameOfPerson + " released no videos and is followed by " + newFollower + ".");
		}
		else if(follower == 0) {
			for(int i = 0; i < totalViews; i++) {
				vid= vid + vidsArray[i];
					if(i+1<totalViews) {vid=vid+", ";}}
				vid=vid+">";String string = "";
				return (nameOfPerson + " released " + vid + " and has no followers.");}
		
		for(int i = 0; i < follower;) {newFollower= newFollower + followers[i].Followertype + " " + followers[i].followerName;
		if(1+i<follower) {newFollower=newFollower+", ";}i++;}
		
		for(int i = 0; i < totalViews; ) {vid=vid+vidsArray[i];
			if(i+1<totalViews) {vid=vid+", ";}i++;}
		
		vid = vid + ">";newFollower= newFollower + "]";
		return nameOfPerson + " released " + vid + " and is followed by " + newFollower + ".";
	}
	
	public void follow(Follower newFollower) {followers[follower] = newFollower; newFollower.addChannel(this); follower++;}

}
