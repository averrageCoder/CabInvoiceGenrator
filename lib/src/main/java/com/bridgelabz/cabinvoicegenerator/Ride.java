package com.bridgelabz.cabinvoicegenerator;

public class Ride {
	enum TypeOfRide {
		NORMAL_RIDE, PREMIUM_RIDE
	}
	
	int time;
	double distance;
	TypeOfRide typeOfRide;
	
	public Ride(double distance, int time, TypeOfRide type) {
		this.distance = distance;
		this.time = time;
		this.typeOfRide = type;
	}

}
