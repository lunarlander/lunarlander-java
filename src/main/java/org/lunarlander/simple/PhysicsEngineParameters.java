package org.lunarlander.simple;

class PhysicsEngineParameters {
	public final Spaceship spaceship;
	public final Planet planet;
	public final double heightAboveGround; 
	public final double verticalVelocity;
	public final long timestamp;
	
	public PhysicsEngineParameters(final Spaceship spaceship, 
			final Planet planet, 
			final double heightAboveGround, 
			final double verticalVelocity){
		this.spaceship = spaceship;
		this.planet = planet;
		this.heightAboveGround = heightAboveGround;
		this.verticalVelocity = verticalVelocity;
		this.timestamp = System.nanoTime();
		
	}
	
	public PhysicsEngineParameters(final PhysicsEngineParameters params, 
			final double heightAboveGround, 
			final double verticalVelocity){
		this.spaceship = params.spaceship;
		this.planet = params.planet;
		this.heightAboveGround = heightAboveGround;
		this.verticalVelocity = verticalVelocity;
		this.timestamp = System.nanoTime();
		
	}

}