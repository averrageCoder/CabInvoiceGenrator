package com.bridgelabz.cabinvoicegenerator;

import com.bridgelabz.cabinvoicegenerator.Ride.TypeOfRide;

public class InvoiceGenerator {

	public double calculateFare(double distance, int time, TypeOfRide type) {
		double COST_PER_KM;
		int COST_PER_TIME;
		double MINIMUM_FARE;
		if(type==TypeOfRide.NORMAL_RIDE) {
			COST_PER_KM = 10;
			COST_PER_TIME = 1;
			MINIMUM_FARE = 5;
		}
		else {
			COST_PER_KM = 15;
			COST_PER_TIME = 2;
			MINIMUM_FARE = 20;
		}
		double fare = COST_PER_KM * distance + COST_PER_TIME * time;
		return Math.max(fare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride: rides) {
			totalFare += this.calculateFare(ride.distance, ride.time, ride.typeOfRide);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

}
