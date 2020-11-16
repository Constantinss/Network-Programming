package wolfpack;

import java.util.ArrayList;
import java.util.List;

public class Packs {

	private List<Pack> packs = new ArrayList<Pack>();
	
	public Packs() {
		super();
	}
	

	
	/**
	 * @return the packs
	 */
	public List<Pack> getPacks() {
		return packs;
	}
	
	

	/**
	 * @param packs the packs to set
	 */
	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}
	
	

	/** 
	 * Adds a pack to the container.
	 * @param pack the Pack to be added
	 * @return true if pack was successfully added
	 */
	public boolean addPack(Pack pack) {
		
		if(!collisionFound(pack)) {
			this.packs.add(pack);
			return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * Removes a pack from the container.
	 * @param pack the Pack to be removed
	 * @return true if pack was present in the collection
	 */
	public boolean removeWolf(Pack pack) {
		
		return packs.remove(pack);
	}
	
	
	
	/**
	 * Returns the total count of packs in the container.
	 * @return
	 */
	public int size() {
		return packs.size();
	}	
	
	
	
	/**
	 *  Removes all packs from the container.
	 */
	public void removeAllPacks() {
		for(Pack pack : packs) {
			packs.remove(pack);
		}
	}
	
	
	
	/** 
	 * 
	 * @param name the Pack name 
	 * @return pack from Packs
	 */
	public Pack getPackByName(String name) {
		Pack pack = new Pack();
		
		for (Pack p : packs) {
			if(p.getName().equals(name)) {
				pack = p;
				break;
			}
		}
		
		return pack;
	}
	
	
	
	/**
	 * Checks whether a Pack is present in the container.
	 * @param pack the Pack to check
	 * @return true if pack is present
	 */
	private boolean collisionFound(Pack pack) {
		for (Pack p : packs) {
			if(p.getName().equals(pack.getName())) return true;
		}
		
		return false;
	}
}
