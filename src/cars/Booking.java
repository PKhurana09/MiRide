package cars;

import utilities.*;

public class Booking {
	private String id;
	private double bookingFee;
	private DateTime pickUpDateTime;
	private String firstName;
	private String lastName;
	private int numPassengers;
	private double kilometersTravelled;
	private double tripFee;
	private Car car;

	public Booking(String firstName, String lastName, DateTime required, int numPassengers, Car car) {
		generateId(car.getRegistrationNo(), firstName, lastName, required);
		setDate(required); // This will validate and set the DateTime
		setFirstName(firstName);
		setLastName(lastName);
		this.car = car;
		this.numPassengers = numPassengers;
	}
	
	

	// Validate the date and check if the date is within the range
	public void setDate(DateTime date) {
		if (DateUtilities.dateIsNotInPast(date) && DateUtilities.dateIsNotMoreThan7Days(date)) {
			this.pickUpDateTime = date;
		}
	}

	// Validate the firstName. Make sure that the firstName is atleast of 3
	// characters.
	public void setFirstName(String fName) {
		if (fName.length() >= 3) {
			this.firstName = fName;
		} else {
			this.firstName = "Error! First Name must have atleast 3 characters";
		}
	}
	
	public void setLastName(String lName) {
		if(lName.length() >= 3) {
			this.lastName = lName;
		}else {
			this.lastName = "Error! Last Name must have atleast 3 characters";
		}
	}

	// Setter method to setId
	public void generateId(String regNo, String firstName, String lastName, DateTime date) {
		if (firstName.length() < 3 || lastName.length() < 3 || date == null) {
			this.id = "Invalid";
		} else {
			this.id = regNo + "_" + firstName.substring(0, 3).toUpperCase() + lastName.substring(0, 3).toUpperCase()
					+ "_" + date.getEightDigitDate();
		}
	}
	
	
	
	// Getter method to getID
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public DateTime getBookingDate() {
		return pickUpDateTime;
	}

}
