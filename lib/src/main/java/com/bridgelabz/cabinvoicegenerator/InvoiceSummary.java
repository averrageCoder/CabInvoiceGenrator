package com.bridgelabz.cabinvoicegenerator;

import java.util.Objects;

public class InvoiceSummary {

	private int numOfRides;
	private double totalFare;
	private double averageFare;

	public InvoiceSummary(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.averageFare = totalFare / numOfRides;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		return Double.doubleToLongBits(averageFare) == Double.doubleToLongBits(other.averageFare)
				&& numOfRides == other.numOfRides
				&& Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
	}

}
