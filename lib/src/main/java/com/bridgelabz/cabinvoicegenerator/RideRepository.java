package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	
	Map<String, Ride[]> ridesRepository = new HashMap<String, Ride[]>();
	
	public Ride[] addRidesForUser(String userID, Ride[] rides) {
		return ridesRepository.put(userID, rides);
	}
	
	public Ride[] getRides(String userID) {
		return ridesRepository.get(userID);
	}

}
