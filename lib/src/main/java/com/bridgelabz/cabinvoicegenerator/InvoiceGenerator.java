package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;

	public double calculateFare(double distance, int time) {
		double fare = COST_PER_KM * distance + COST_PER_TIME * time;
		if(fare < 5)
			return 5;
		else
			return fare;
	}

}
