package org.lunarlander.simple;


class PhysicsEngine {
	public PhysicsEngineParameters 
		calculatePositionAndVelocity(PhysicsEngineParameters p, ControlFunction c) {

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
						p.spaceship.fuelMass - lostMass, 
						p.spaceship.velociyOfTheExhaustedGasses,
						p.spaceship.burnRate);
		
		return new PhysicsEngineParameters(updatedSpaceship, p.planet, 
				heightAboveGround, p.verticalVelocity + deltaVerticalVelocity);
	}
	
	private static double nanosToSeconds(long timeInNannos) {
		return ((double)timeInNannos)*1E-9;
	}
}