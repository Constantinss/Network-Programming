package org.elsys.netprog.rest;

import java.util.ArrayList;
import java.util.List;

public class CarsContainer {
	List<CarRegister> cars = new ArrayList<CarRegister>();

	public CarsContainer() {
		super();
	}
	
	public boolean addCar(CarRegister car) {
			if(!collisionFound(car.getCarReg())) {
				this.cars.add(car);
				return true;
			}
		return false;
	}
	
	public CarRegister getCarByReg(String registration){
		for(CarRegister c : this.cars) {
			if(c.getCarReg().equals(registration)) {
				return c;
			}
		}
		return null;
	}
	
	public List<CarRegister> getAllCars() {
		return this.cars;
	}

	private boolean collisionFound(String registration) {
		for(CarRegister c : cars) {
			if(c.getCarReg().equals(registration)) return true;
		}
		return false;
	}
	

	
}