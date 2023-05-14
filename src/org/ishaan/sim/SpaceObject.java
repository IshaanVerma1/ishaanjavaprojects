package org.ishaan.sim;

public class SpaceObject {
	private double velocityX;//1,000's of km/s
	private double velocityY;
	private long weightInKG;//1,000's of KG
	private double XCoordinate;
	private double YCoordinate;
	private int objNum;
	


	public int getObjNum() {
		return objNum;
	}

	public void setObjNum(int objNum) {
		this.objNum = objNum;
	}

	public SpaceObject() {
		this.velocityX = 100;
		this.weightInKG = 100;
	}
	
	public SpaceObject(double speedInKM, long weightInKG) {
		this.velocityX = speedInKM;
		this.weightInKG = weightInKG;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public double getWeightInKG() {
		return weightInKG;
	}

	public void setWeightInKG(long weightInKG) {
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
	
	public String toString() {
		String str = "Current Position: (" + XCoordinate + "," + YCoordinate + ")\nWeight (in tons): " + weightInKG +"\nCurrent Velocity:\n\tHorizontal: " + velocityX + "\n\tVertical: " + velocityY;
		return str;
	}
}
