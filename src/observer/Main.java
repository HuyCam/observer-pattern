package observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

}

//Subject.java

interface Subject {
	
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
	
	
}




//Channel.java

class Channel implements Subject {
	private ArrayList<Observer> obs;
	private String channelName;
	private String status;
	
	public Channel(String name) {
		this.channelName = name;
		this.obs = new ArrayList<>();
		this.status = "offline";
	}
	
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		obs.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		Iterator<Observer> iterator = this.obs.iterator();
		while(iterator.hasNext()) {
			Observer obs = iterator.next();
			if (observer.getName().equals(observer.getName())) {
				this.obs.remove(obs);
				break;
			}
		}
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		if (this.status.equals("live")) {
			Iterator<Observer> iterator = this.obs.iterator();
			while(iterator.hasNext()) {
				Observer obs = iterator.next();
				obs.update(this.status);
			}
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
  
}


//Observer.java

interface Observer {
	public void update(String status);
	
	public String getName();
}





// Follower.java

class Follower implements Observer {

	private String followerName;
	
	public Follower(String name) {
		this.followerName = name;
	}

	@Override
	public void update(String status) {
		System.out.println("Channel is" + status);
		
	}

	@Override
	public String getName() {
		return this.followerName;
	}
	
	public void play() {
		System.out.println("Playing videos on this channel");
	}

}