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

	// Need to complete this method with kilometers traveled somehow.
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("-15s %s\n", "id: ", id));
		sb.append(String.format("-15s %s\n", "BookingFee: ", bookingFee));
		sb.append(String.format("-15s %s\n", "Pick Up Date: ", pickUpDateTime));
		sb.append(String.format("-15s %s%s\n", "Name: ", firstName, " ", lastName));
		sb.append(String.format("-15s %s\n", "Passenger: ", numPassengers));
		sb.append(String.format("-15s %s\n", "Travelled: ", kilometersTravelled));
		sb.append(String.format("-15s %s\n", "Trip Fee: ", tripFee));
		sb.append(String.format("-15s %s\n", "Car ID: ", car.getRegistrationNo()));
		return sb.toString();
	}

	// Need to complete this method with kilometers traveled as well same as the above method 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id + ":" + bookingFee + ":" + pickUpDateTime + ":" + firstName + " " + lastName + ":"
				+ kilometersTravelled + ":" + tripFee + ":" + car.getRegistrationNo());
		return sb.toString();
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
		if (lName.length() >= 3) {
			this.lastName = lName;
		} else {
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

	public void setBookingFee() {
		bookingFee = 1.50;
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

	public double getKilometersTravelled() {
		return kilometersTravelled;
	}

}
