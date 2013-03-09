package org.lunarlander.simple;

public enum Planet {
	
	MOON(7.352E+22, 1.63d, 1737.5d, 0.036601d); // even the moon is not a planet
	
	 // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

	
	
	public final double massInKg;
	
	// this we may also caluclate
	public final double gravitationalAccelleration;
	
	public final double radiusInKm;
	
	public final double rotationFrequencyPerDay;

	
	private Planet(final double massInKg, final double gravitationalAccelleration 
			, final double radiusInKm, final double rotationFrequencyPerDay) {
		this.massInKg = massInKg;
		this.gravitationalAccelleration = gravitationalAccelleration;
		this.radiusInKm = radiusInKm;
		this.rotationFrequencyPerDay = rotationFrequencyPerDay;
	}
}
