package cars;

import utilities.*;

public class Car {
	
	// Car Attributes
	private String regNo;
	private String make;
	private String model;
	private String driverName;
	private int passengerCapacity;
	
	// Booking Attributes
	private boolean available;
	private Booking[] currentBookings;
	private Booking[] pastBookings;

	public Car(String regNo, String make, String model, String driverName, int passengerCapacity) {
		setRegNo(regNo); //This will validate and set the registration number from setter method.
		setPassengerCapacity(passengerCapacity); // This will validate and set the passengerCapacity from setter method.
		
		this.make = make;
		this.model = model;
		this.driverName = driverName;
	}
	
	// Human readable method 
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s %s\n", "Reg No:", regNo));
		sb.append(String.format("%-15s %s\n", "Make & Model:", make + " " + model));
		
		sb.append(String.format("%-15s %s\n", "Driver Name:", driverName));
		sb.append(String.format("%-15s %s\n", "Capacity: ", passengerCapacity));
		
		if(bookingAvailable()) {
			sb.append(String.format("%-15s %s\n", "Available: ", "YES"));			
		}else {
			sb.append(String.format("%-15s %s\n", "Available: ", "NO"));						
		}
		
		return sb.toString();
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(regNo + ":" + make + ":" + model);
		if(driverName != null) {
			sb.append(":" + driverName);
		}
		sb.append(":" + passengerCapacity);
		if(bookingAvailable()) {
			sb.append(":" + "YES");
		}else {
			sb.append(":" + "NO");
		}
		
		return sb.toString();
	}
	
	
	// Need to be implemented yet just left it for now
	public boolean bookingAvailable() {
		return true;
	}
	
	// Setter method for regNo
	public void setRegNo(String regNo) {
		if(!MiRidesUtilities.isRegNoValid(regNo).contains("Error")) {
			this.regNo = regNo;
		}else {
			this.regNo = "invalid! Please try again!";
		}
	}
	
	// Setter method for passengerCapacity
	public void setPassengerCapacity(int passengerCapacity) {
		if(!MiRidesUtilities.isPassengerCapacityValid(passengerCapacity).contains("Error")) {
			this.passengerCapacity = passengerCapacity;
		}else {
			this.passengerCapacity = -1;
		}
	}
	
	// Getter method for required things
	public String getRegistrationNo() {
		return regNo;
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

}
