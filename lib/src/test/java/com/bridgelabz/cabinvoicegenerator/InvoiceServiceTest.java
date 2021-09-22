package com.bridgelabz.cabinvoicegenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.cabinvoicegenerator.Ride.TypeOfRide;

public class InvoiceServiceTest {
	
	InvoiceGenerator invoiceGenerator = null;
	RideRepository rideRepository;
	
	@BeforeEach
	public void setup() {
		invoiceGenerator = new InvoiceGenerator();
		rideRepository = new RideRepository();
	}
	
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		double distance = 2.0;
		int time = 2;
		double fare = invoiceGenerator.calculateFare(distance, time,  TypeOfRide.PREMIUM_RIDE);
		assertEquals(34, fare);
	}
	
	@Test
	public void givenLessDistanceAndTime_shouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time,  TypeOfRide.NORMAL_RIDE);
		assertEquals(5, fare);
	}
	
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { 
				new Ride(2.0, 5, TypeOfRide.NORMAL_RIDE),
				new Ride(0.1, 2, TypeOfRide.NORMAL_RIDE)
				};
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenUserID_shouldReturnInvoiceSummary() {
		Ride[] ridesForUser1 = { 
				new Ride(2.0, 5, TypeOfRide.NORMAL_RIDE),
				new Ride(0.1, 2, TypeOfRide.NORMAL_RIDE)
				};
		rideRepository.addRidesForUser("101", ridesForUser1);
		
		Ride[] ridesForUser2 = { 
			new Ride(5.0, 5, TypeOfRide.NORMAL_RIDE),
			new Ride(0.1, 2, TypeOfRide.NORMAL_RIDE)
		};
		rideRepository.addRidesForUser("102", ridesForUser2);
		
		Ride[] rides = rideRepository.getRides("102");
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 60.0);
		assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void giventypeOfRide_shouldReturnInvoiceSummary() {
		Ride[] ridesForUser1 = { 
				new Ride(2.0, 5, TypeOfRide.NORMAL_RIDE),
				new Ride(0.1, 2, TypeOfRide.NORMAL_RIDE)
				};
		rideRepository.addRidesForUser("101", ridesForUser1);
		
		Ride[] ridesForUser2 = { 
			new Ride(5.0, 5, TypeOfRide.NORMAL_RIDE),
			new Ride(0.1, 2, TypeOfRide.NORMAL_RIDE),
			new Ride(4.0, 2, TypeOfRide.PREMIUM_RIDE)
		};
		rideRepository.addRidesForUser("102", ridesForUser2);
		
		Ride[] rides = rideRepository.getRides("102");
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		
		InvoiceSummary expectedSummary = new InvoiceSummary(3, 124.0);
		assertEquals(expectedSummary, summary);
	}
	
}
