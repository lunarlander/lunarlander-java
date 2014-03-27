package org.lunarlander.simple;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


class PhysicsEngine {
	public static final MathContext SIX_VALID_DIGITS = 
			new MathContext(6,RoundingMode.HALF_UP);
	
	final private MathContext mathContext = SIX_VALID_DIGITS;
	
	public PhysicsEngineParameters 
		calculatePositionAndVelocity(PhysicsEngineParameters p, ControlFunction c) {

		delayUntilSystemTimeNanosNotEqual(p.timestamp);
		double deltaT = nanosToSeconds(System.nanoTime() - p.timestamp); 
		double lostMass = c.getMassChangeInKg(deltaT);
		double thrust = p.spaceship.velociyOfTheExhaustedGasses * lostMass;
		double acceleration = p.planet.gravitationalAccelleration - 
				thrust/p.spaceship.getTotalMass();
		System.out.println(String.format(
				"Velocity of the exhausted gasses / (m/s) = %f, lost Mass / kg =  %f, Thurst = %f, Accelleration = %f" , 
				p.spaceship.velociyOfTheExhaustedGasses,
				lostMass,
				thrust,
				acceleration
				));

		double deltaVerticalVelocity = acceleration * deltaT;
		double heightAboveGround = p.heightAboveGround - p.verticalVelocity * deltaT;
		
				
		Spaceship updatedSpaceship = 
				new Spaceship(p.spaceship.massOfTheEmptySpaceship,
						round(p.spaceship.fuelMass - lostMass), 
						p.spaceship.velociyOfTheExhaustedGasses,
						p.spaceship.burnRate);
		
		return new PhysicsEngineParameters(updatedSpaceship, p.planet, 
				heightAboveGround, p.verticalVelocity + deltaVerticalVelocity);
	}
	
	private void delayUntilSystemTimeNanosNotEqual(long timeInNanosToCompare) {
		// delay so that delta time in nanos is never 0.0
		while (System.nanoTime() == timeInNanosToCompare) {}
	}
	
	
	private double round(double value) {
		return (new BigDecimal(value))
		.round(mathContext).doubleValue();
	}
	
	private static double nanosToSeconds(long timeInNannos) {
		return ((double)timeInNannos)*1E-6;
	}
}