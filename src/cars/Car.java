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
	private int bookingSpotAvailable = 0;
	private Booking[] currentBookings;
	private Booking[] pastBookings;

	// Constants
	private final double STANDARD_BOOKING_FEE = 1.50;
	private final int MAXIMUM_PASSENGER_CAPACITY = 10;
	private final int MINIMUM_PASSENGER_CAPACITY = 0;

	public Car(String regNo, String make, String model, String driverName, int passengerCapacity) {
		setRegNo(regNo); // This will validate and set the registration number from setter method.
		setPassengerCapacity(passengerCapacity); // This will validate and set the passengerCapacity from setter method.

		this.make = make;
		this.model = model;
		this.driverName = driverName;
	}

	// Needs to be completed
	public boolean book(String firstName, String lastName, DateTime required, int numPassengers) {

		return false;
	}

	/*
	 * This checks if the date is not in past and not in more than 7 days in future.
	 */
	public boolean isDateValid(DateTime required) {
		return DateUtilities.dateIsNotInPast(required) && DateUtilities.dateIsNotMoreThan7Days(required);
	}

	/*
	 * This checks if there is booking for today
	 */
	public boolean isBookingAvailableToday(DateTime required) {
		boolean isAvailable = true;
		for (int i = 0; i != currentBookings.length; i++) {
			if (currentBookings[i] != null) {
				if (DateUtilities.datesAreTheSame(required, currentBookings[i].getBookingDate())) {
					isAvailable = false;
				}
			}
		}
		return isAvailable;
	}

	/*
	 * To check if there is more then 5 bookings
	 */
	public boolean isThereMorethan5Bookings() {
		int counter = 0;
		for (int i = 0; i != currentBookings.length; i++) {
			if (currentBookings[i] != null) {
				counter++;
			}
		}
		if (counter >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 *  Is number of passenger within the range of passenger capacity 
	 */
	public boolean validPassengerCapacity(int numPassengers) {
		if(numPassengers > MINIMUM_PASSENGER_CAPACITY && numPassengers < MAXIMUM_PASSENGER_CAPACITY) {
			return true;
		}else {
			return false;
		}
	}
	
    /*
     * This sets the booking spot where the position is available. 
     */	
	public boolean bookingAvailable() {
		boolean isAvailable = false;
		for(int i = 0; i != currentBookings.length; i++) {
			if(currentBookings[i] == null) {
				isAvailable = true;
				bookingSpotAvailable = i;
			}
		}
		return isAvailable;
	}

	// Human readable method
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s %s\n", "Reg No:", regNo));
		sb.append(String.format("%-15s %s\n", "Make & Model:", make + " " + model));

		sb.append(String.format("%-15s %s\n", "Driver Name:", driverName));
		sb.append(String.format("%-15s %s\n", "Capacity: ", passengerCapacity));

		if (bookingAvailable()) {
			sb.append(String.format("%-15s %s\n", "Available: ", "YES"));
		} else {
			sb.append(String.format("%-15s %s\n", "Available: ", "NO"));
		}

		return sb.toString();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(regNo + ":" + make + ":" + model);
		if (driverName != null) {
			sb.append(":" + driverName);
		}
		sb.append(":" + passengerCapacity);
		if (bookingAvailable()) {
			sb.append(":" + "YES");
		} else {
			sb.append(":" + "NO");
		}

		return sb.toString();
	}

	// Setter method for regNo
	public void setRegNo(String regNo) {
		if (!MiRidesUtilities.isRegNoValid(regNo).contains("Error")) {
			this.regNo = regNo;
		} else {
			this.regNo = "invalid! Please try again!";
		}
	}

	// Setter method for passengerCapacity
	public void setPassengerCapacity(int passengerCapacity) {
		if (!MiRidesUtilities.isPassengerCapacityValid(passengerCapacity).contains("Error")) {
			this.passengerCapacity = passengerCapacity;
		} else {
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
