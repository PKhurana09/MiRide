package main;

import cars.Car;

public class Driver {
	public static void main(String[] args) {
		Car c1 = new Car("ABC123", "Tata", "2023", "Pranav Khurana", 5);
		System.out.println(c1.getDetails());
		System.out.println(c1.toString());
	}
}
