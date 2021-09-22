package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double fare = COST_PER_KM * distance + COST_PER_TIME * time;
		if(fare < MINIMUM_FARE)
			return MINIMUM_FARE;
		else
			return fare;
	}

}
