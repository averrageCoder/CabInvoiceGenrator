package com.bridgelabz.cabinvoicegenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(22, fare);
	}
	
	@Test
	public void givenLessDistanceAndTime_shouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare);
	}
	
	@Test
	public void givenMultipleRides_shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { 
				new Ride(2.0, 5),
				new Ride(0.1, 2)
				};
		double fare = invoiceGenerator.calculateFare(rides);
		assertEquals(30, fare);
	}
	
}
