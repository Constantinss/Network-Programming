package wolfpack;

public class Pack {
	private String name;
	private Wolves wolves = new Wolves();
	
	public Pack() {
		super();
	}


	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the wolves
	 */
	public Wolves getWolves() {
		return wolves;
	}



	/**
	 * @param wolves the wolves to set
	 */
	public void setWolves(Wolves wolves) {
		this.wolves = wolves;
	}
	
	
	
	/**
	 * Removes a wolf from the Pack.
	 * @param removeWolf the Wolf to be removed
	 * @return true if wolf was successfully removed
	 */	
	public boolean removeWolf(Wolf removeWolf) {
		return wolves.getWolves().remove(removeWolf);		
	}



	/**
	 * Adds a wolf in the Pack.
	 * @param addWolf the Wolf to be added
	 * @return true if wolf was successfully added
	 */	
	public boolean addWolf(Wolf addWolf) {
		return wolves.getWolves().add(addWolf);		
	}
	
	
	
	/**
	 * Removes a wolves from the Pack.
	 * @param removeWolves the Wolves to be removed
	 */	
	public void removeWolves(Wolves removeWolves) {
		for (Wolf wolf : removeWolves.getWolves())
			wolves.removeWolf(wolf);
		
	}
	
	
	
	/**
	 * 
	 * Removes a all wolves from the Pack
	 */
	public void removeAllWolves() {
		wolves.getWolves().clear();		
	}
	
}
