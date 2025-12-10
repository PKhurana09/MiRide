package app;

import cars.Car;

public class MiRideApplication {
	private Car[] MiCars = new Car[15]; 
	
	public boolean seedData() {
		MiCars[0] = new Car("SIM194", "Honda", "Accord Euro", "Pranav Khurana", 7 );		
		return true;
	}
}
