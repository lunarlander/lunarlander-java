package org.lunarlander.simple;

public class Spaceship {
	
	public final double massOfTheEmptySpaceship;
	
	public final double fuelMass;
	
	public final double velociyOfTheExhaustedGasses;
	
	public final double burnRate;
	

	public Spaceship(final double massOfTheEmptySpaceship, 
			final double fuelMass, 
			final double velociyOfTheExhaustedGasses, 
			final double burnRate) {
		this.fuelMass = fuelMass;
		this.massOfTheEmptySpaceship = massOfTheEmptySpaceship;
		this.velociyOfTheExhaustedGasses = velociyOfTheExhaustedGasses;
		this.burnRate = burnRate;
	}
	
	public double getTotalMass() {
		return fuelMass + massOfTheEmptySpaceship;
	}
	
	

}
