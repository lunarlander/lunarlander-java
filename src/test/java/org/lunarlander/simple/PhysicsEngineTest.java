package org.lunarlander.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PhysicsEngineTest {
	
	private PhysicsEngine engine;
	
	@Before
	public void setUp() {
		engine = new PhysicsEngine();
	}

	@Test
	public void testFreeFall() {
		// our spaceship does not exhaust any gased independent of the control function
		// thus we a free fall
		// lets use a mass of null - mass does not matter for the free fall.
		Spaceship spaceship = new Spaceship(500, 1e3,0.0, 0.0);
		ControlFunction f = new ControlFunction(spaceship);
		
		// lets start at a height of 5km
		// and with no vertical velocity
		PhysicsEngineParameters params = 
				new PhysicsEngineParameters(spaceship, Planet.MOON, 5.0E3, 0.0);
		
		
		while (params.heightAboveGround > 0.0) {
			params = engine.calculatePositionAndVelocity(params, f);
			System.out.println(String.format("Height above Ground / km : %f, Vertical velocity / (m/s) %f", 
					params.heightAboveGround / 1E3, params.verticalVelocity));
		}
		
	
		// v = sqrt(2hg)
		assertTrue(String.format(
				"Wrong end velocity Expected %f, acutal %f", 
				127.671, 
				params.verticalVelocity),
				Math.abs(127.671 - params.verticalVelocity) < 0.5);
		
	}
	@Ignore
	@Test
	public void testVerticalStart() {
		// our spaceship stands on the ground
		// the velocity of the exhausted gases is 50m/s
		// and we burn 100 kg/s
		// we have a fuel mass of 1000kg 
		// so we have 10s to bring our spaceship up to
		// the air.
		Spaceship spaceship = new Spaceship(500, 1e3, 2614.0, 5213.0);
		ControlFunction f = new ControlFunction(spaceship);
		
		// lets start at a height of 5km
		// and with no vertical velocity, 'cause we are standing on the ground
		PhysicsEngineParameters params = 
				new PhysicsEngineParameters(spaceship, Planet.MOON, 0.0, 0.0);
		
		
		while (params.heightAboveGround >= 0.0d) {
			params = engine.calculatePositionAndVelocity(params, f);
			f = new ControlFunction(params.spaceship);
			if (params.spaceship.burnRate >= 0.0 && params.spaceship.fuelMass >= 0.0 
					&& params.heightAboveGround < 0.0 ) {
				// spaceship not started - height should be not negative and velocity 0
				// TODO should this be part of the PhysicsEngine ? 
				params = new PhysicsEngineParameters(params, 0.0d, 0.0d);
			}
			System.out.println(String.format("Height above Ground / km : %f, Vertical velocity / (m/s) %f", 
					params.heightAboveGround / 1E3, params.verticalVelocity));
		}
		
	}

}
