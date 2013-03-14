package org.lunarlander.simple;

public class ControlFunction {
	
	public final Spaceship spaceship;
	
	public ControlFunction(final Spaceship spaceship) {
		this.spaceship = spaceship;
	}
	
	/**
	 * Returns the change of Mass during the given time intervall.
	 * The function only returns the change of mass only if
	 * there the spaceship has fuel.
	 * 
	 * @param deltaTimeInNannoseconds
	 * @return
	 */
	public double getMassChangeInKg(final double deltaTimeInSeconds) {
		double remainingBurnTimeInSeconds =  
				spaceship.burnRate != 0.0d ? spaceship.fuelMass / spaceship.burnRate 
						: 0.0d;
		
		assert remainingBurnTimeInSeconds >= 0 
				: String.format("Remaining burn tinme %f is negeative", remainingBurnTimeInSeconds);
		

		double burnTime=Math.min(remainingBurnTimeInSeconds, deltaTimeInSeconds);
		System.out.println(String.format("Burn Rate %f, delta t / s %f ", spaceship.burnRate,burnTime ));
		return spaceship.burnRate * burnTime;
	}

}
