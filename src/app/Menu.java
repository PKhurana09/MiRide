package app;

import cars.Car;
import utilities.MiRidesUtilities;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public void run() {
		final int MENU_COUNT = 2;
		String choice = "";
		String input;
		do {
			printMenu();
			input = sc.nextLine().toUpperCase();
			if (input.length() != MENU_COUNT) {
				System.out.println("Error - Selection must be of 2 characters!");
			} else {
				System.out.println();
				switch (input) {
				case "CC":
					System.out.println("We wil run the method called Create Car here.");
					break;
				case "BC":
					System.out.println("We will run the method called Book Car here");
					break;
				case "CB":
					System.out.println("We will run the method called Complete Booking here");
					break;
				case "DA":
					System.out.println("We will run the method called Display all cars here");
					break;
				case "SS":
					System.out.println("We will run the method called Search specified cars method here");
					break;
				case "SA":
					System.out.println("We will run the method called Search available cars here");
					break;
				case "SD":
					System.out.println("We will run the method called Seed data here");
					break;
				case "EX":
					System.out.println("Exiting Program GoodBye");
					break;
				default:
					System.out.println("You prompted a wrong selection please try again!");
				}
			}
		} while (choice != "EX");
	}

	/*
	 * This method is to print the menu
	 */
	public void printMenu() {
		System.out.printf("\n***MiRides System Menu***\n\n");

		System.out.printf("%-30s %s\n", "Create Car", "CC");
		System.out.printf("%-30s %s\n", "Book Car", "BC");
		System.out.printf("%-30s %s\n", "Complete Booking", "CB");
		System.out.printf("%-30s %s\n", "Display All Cars", "DA");
		System.out.printf("%-30s %s\n", "Search Specified Cars", "SS");
		System.out.printf("%-30s %s\n", "Search Available cars", "SA");
		System.out.printf("%-30s %s\n", "Seed Data", "SD");
		System.out.printf("%-30s %s\n", "Exit Program", "EX");
		System.out.println("Please enter your selection from above!");
		System.out.println("To exit the menu please press enter!");
	}
	
	
	public void createCar() {
		String id, make, model, driverName;
		int capacity;
		Scanner sc = new Scanner(System.in);
		
		// Getting details for the Car
		// Registration number of the Car
		System.out.println("Please enter the Registration Number of the car.");
		id = sc.nextLine();
		if(utilities.MiRidesUtilities.isRegNoValid(id).contains("Error")) {
			System.out.println("There is an error please try again later.");
		}
		// Make of the Car
		System.out.println("Please enter the Make of the car.");
		make = sc.nextLine();
		
		// Model of the Car
		System.out.println("Please enter the model of the car.");
		model = sc.nextLine();
		
		// DriverName
		System.out.println("Please enter the driver name.");
		driverName = sc.nextLine();
		
		System.out.println("Please enter the passenger capacity");
		capacity = sc.nextInt();
		
		if(utilities.MiRidesUtilities.isPassengerCapacityValid(capacity).contains("Error")) {
			System.out.println("There is an error please try again later.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
