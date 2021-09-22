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
	
}
