package wolfpack;

import java.util.ArrayList;
import java.util.List;

public class Wolves{
	private List<Wolf> wolves = new ArrayList<Wolf>();

	public Wolves() {
		super();
	}


	
	/**
	 * @return the wolves
	 */
	public List<Wolf> getWolves() {
		return wolves;
	}



	/**
	 * @param wolves the wolves to set
	 */
	public void setWolves(List<Wolf> wolves) {
		this.wolves = wolves;
	}



	/** 
	 * Adds a wolf to the container.
	 * @param wolf the Wolf to be added
	 * @return true if wolf was successfully added
	 */
	public boolean addWolf(Wolf wolf) {
		
		if(!collisionFound(wolf)) {
			this.wolves.add(wolf);
			return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * Removes a wolf from the container.
	 * @param wolf the Wolf to be removed
	 * @return true if wolf was present in the collection
	 */
	public boolean removeWolf(Wolf wolf) {
		
		return wolves.remove(wolf);
	}
	
	
	
	/**
	 * Updates a wolf from the container.
	 * @param oldWolf, newWolf the Wolf to be updated with new Wolf
	 * @return true if wolf was present in the collection
	 */
	public boolean updateWolf(Wolf oldWolf, Wolf newWolf) {
		int indexOfWolf = wolves.indexOf(oldWolf);
		
		wolves.set(indexOfWolf, newWolf);
		
		if(wolves.contains(newWolf)) {
			return true;
		}
		
		return false;
	}
	

	
	/**
	 * Returns the total count of wolves in the container.
	 * @return
	 */
	public int size() {
		return wolves.size();
	}
	
	

	/**
	 *  Removes all wolves from the container.
	 */
	public void removeAllWolves() {
		for(Wolf wolf : wolves) {
			wolves.remove(wolf);
		}
	}
	
	
	
	/** 
	 * 
	 * @param name the Wolf name 
	 * @return wolf from Wolves
	 */
	public Wolf getWolfByName(String name) {
		Wolf wolf = new Wolf();
		
		for (Wolf w : wolves) {
			if(w.getName().equals(name)) {
				wolf = w;
				break;
			}
		}
		
		return wolf;
	}

	
	
	/**
	 * Checks whether a Wolf is present in the container.
	 * @param wolf the Wolf to check
	 * @return true if wolf is present
	 */
	private boolean collisionFound(Wolf wolf) {
		for (Wolf w : wolves) {
			if(w.getName().equals(wolf.getName())) return true;
		}
		
		return false;
	}
}
