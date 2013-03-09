package org.lunarlander.simple;


public class Game {
	
	private class SpaceshipControll implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Spaceship spaceship = new Spaceship(1.00, 500, 2.00, 3.00);
		Planet moon = Planet.MOON;
		
	}

}
