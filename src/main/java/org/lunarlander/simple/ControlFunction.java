package org.lunarlander.simple;

public class ControlFunction {
	
	public final Spaceship spaceship;
	
	public ControlFunction(final Spaceship spaceship) {
		this.spaceship = spaceship;
	}
	
	/**
	 * Returns the change of Mass during the given time intervall.
	 * 
	 * @param deltaTimeInNannoseconds
	 * @return
	 */
	public double getMassChangeInKg(final double deltaTimeInNannoseconds) {
		return spaceship.burnRate * deltaTimeInNannoseconds;
	}

}
