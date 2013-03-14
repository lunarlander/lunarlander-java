package org.lunarlander.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControlFunctionTest {
	
	private static final double EPSILON = 1E-12;
	

	@Test
	public void testGetMassChangeInKgNoFuel() {
		// our spaceship has no fuel 
		// burn rate of 100 kg/s
		Spaceship s = new Spaceship(1E3, 0.0, 2500, 100 );
		ControlFunction f = new ControlFunction(s);
		
		double deltaMInKg = f.getMassChangeInKg(60);
		
		assertTrue(String.format("Wrong delta m = %f for returnd when there was no fuel available.", deltaMInKg),
				Math.abs(deltaMInKg - 0.0d) <=  EPSILON);
		
	}
	
	@Test
	public void testGetMassChangeInKg() {
		// our spaceship 100kg of fuel  
		// burn rate of 100 kg/s
		Spaceship s = new Spaceship(1E3, 100.0, 2500, 100 );
		ControlFunction f = new ControlFunction(s);
		
		double deltaMInKg = f.getMassChangeInKg(60);
		
		// after 60s we expect that we've burned 100kg
		assertTrue(String.format("Wrong delta m = %f for returnd when there was no fuel available.", deltaMInKg),
				Math.abs(deltaMInKg - 100.0d) <=  EPSILON);
	
	}

	@Test
	public void testGetMassChangeInKgAfterFiveMinutes() {
		// our spaceship 100kg of fuel  
		// burn rate of 100 kg/s
		Spaceship s = new Spaceship(1E3, 100.0, 2500, 100 );
		ControlFunction f = new ControlFunction(s);
		
		double deltaMInKg = f.getMassChangeInKg(5 * 60);
		
		// after 5min we expect that we've burned 100kg
		assertTrue(String.format("Wrong delta m = %f for returnd when there was no fuel available.", deltaMInKg),
				Math.abs(deltaMInKg - 100.0d) <=  EPSILON);
		
	}
	
	@Test
	public void testGetMassChangeInKgAfterOneMilliSecond() {
		// our spaceship 100kg of fuel  
		// burn rate of 100 kg/s
		Spaceship s = new Spaceship(1E3, 100.0, 2500, 100 );
		ControlFunction f = new ControlFunction(s);
		
		double deltaMInKg = f.getMassChangeInKg(0.001);
		
		// after 1ms we expect that we've burned 100kg/1000
		assertTrue(String.format("Wrong delta m = %f for returnd when there was no fuel available.", deltaMInKg),
				Math.abs(deltaMInKg - (100.0d/1000)) <=  EPSILON);
		
	}

}
