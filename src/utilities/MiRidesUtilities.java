package utilities;

public class MiRidesUtilities {
	private static int ID_LENGTH = 6;
	
	
	public static String isRegNoValid(String regNo) {
		int regLength = regNo.length();
		if(regLength != ID_LENGTH) {
			return "Error! Registration number must be of 6 characters.";
		}
		boolean letters = regNo.substring(0, 3).matches("[a-zA-Z]+");
		if(!letters) {
			return "Error! The first 3 characters of the Registration number must be alphabets";
		}
		boolean numbers = regNo.substring(3).matches("[0-9]+");
		if(!numbers) {
			return "Error! The last 3 characters of the Registration number must be numbers";
		}
		return regNo;
	}
	
	public static String isPassengerCapacityValid(int passengerCapacity) {
		if(passengerCapacity > 0 && passengerCapacity < 10) {
			return "OK";
		}else {
			return "Error! Passenger capacity must be between 1 and 9.";
		}
	}
}
