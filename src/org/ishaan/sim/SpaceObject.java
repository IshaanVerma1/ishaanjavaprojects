package org.ishaan.sim;

public class SpaceObject {
	private double speedInKM;//1,000's of km
	private double weightInKG;//1,000's of KG
	private double XCoordinate;
	private double YCoordinate;
	


	public SpaceObject() {
		this.speedInKM = 100;
		this.weightInKG = 100;
	}
	
	public SpaceObject(double speedInKM, double weightInKG) {
		this.speedInKM = speedInKM;
		this.weightInKG = weightInKG;
	}
	
	
	public double getSpeedInKM() {
		return speedInKM;
	}
	public void setSpeedInKM(double speedInKM) {
		this.speedInKM = speedInKM;
	}
	public double getWeightInKG() {
		return weightInKG;
	}
	public void setWeightInKG(double weightInKG) {
		this.weightInKG = weightInKG;
	}
	public double getXCoordinate() {
		return XCoordinate;
	}

	public void setXCoordinate(double xCoordinate) {
		XCoordinate = xCoordinate;
	}

	public double getYCoordinate() {
		return YCoordinate;
	}

	public void setYCoordinate(double yCoordinate) {
		YCoordinate = yCoordinate;
	}
}
