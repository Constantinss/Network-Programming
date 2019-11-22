package wolfpack;

public class Wolf {
	
	private String name;
	private String gender;
	private String birthdate;
	private Location location;
	
	public Wolf() {
		super();
		this.name = "Wolf";
		this.gender = "male";
		this.birthdate = "20:11:2019";
		Location defaultLocation = new Location(65.432, 32.10);
		this.location = defaultLocation;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}



	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}



	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}



	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}



	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Wolf other = (Wolf) obj;
		
		if (name == null) {
			if (other.name != null) {
				return false;
			}	
		} else if (!name.equals(other.name)) {
			return false;
		}
		
		if (gender == null) {
			if (other.gender!= null) {
				return false;
			}	
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		
		if (birthdate == null) {
			if (other.birthdate != null) {
				return false;
			}	
		} else if (!birthdate.equals(other.birthdate)) {
			return false;
		}
		
		if (location == null) {
			if (other.location != null) {
				return false;
			}	
		} else if (!location.equals(other.location)) {
			return false;
		}		

		return true;
	}

}
