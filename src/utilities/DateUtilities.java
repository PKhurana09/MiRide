package utilities;

public class DateUtilities {
	
	public static boolean dateIsNotInPast(DateTime date) {
		DateTime today = new DateTime();
		int temp = DateTime.diffDays(date, today);
		if(temp < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean datesAreTheSame(DateTime date1, DateTime date2) {
		if(date1.getEightDigitDate().equals(date2.getEightDigitDate())) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean dateIsNotMoreThan7Days(DateTime date) {
		DateTime today = new DateTime();
		int temp = DateTime.diffDays(date, today);
		
		if(temp <= 7 && temp >= 0) {
			return true;
		}else {
			return false;
		}
	}
}
