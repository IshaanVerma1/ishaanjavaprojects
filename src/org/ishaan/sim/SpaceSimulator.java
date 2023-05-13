package org.ishaan.sim;

public class SpaceSimulator {
	private SpaceObject[] objects = new SpaceObject[2];
	private double distanceX;//distance on x axis
	private double distanceY;//distance on y axis
	private double distance;//distance between spaceObjects
	private final double GRAVCONSTANT = (6.67 * Math.pow(10, -11));
	
	public SpaceSimulator() {
		objects[0] = new SpaceObject(); objects[1] = new SpaceObject();
		objects[0].setXCoordinate(-(100/2));objects[1].setXCoordinate(100/2);
		this.distance = Math.sqrt(Math.pow(objects[1].getXCoordinate()-objects[0].getXCoordinate(), 2) + Math.pow(objects[1].getYCoordinate()-objects[0].getYCoordinate(), 2));
	}
	
	public SpaceSimulator(double speedInKM, double weightInKG, double speedInKM2, double weightInKG2, double distanceX, double distanceY) {
		objects[0] = new SpaceObject(speedInKM, weightInKG); objects[1] = new SpaceObject(speedInKM2, weightInKG2);
		this.distanceX = distanceX;
		this.distanceY = distanceY;
		objects[0].setXCoordinate(-(distanceX/2));objects[1].setXCoordinate(distanceX/2);
		objects[0].setYCoordinate(-(distanceY/2));objects[1].setYCoordinate(distanceY/2);
	}
	
	public double calculateGravitalForce(){
		return (GRAVCONSTANT * objects[0].getWeightInKG() * objects[1].getWeightInKG())/Math.pow(distance, 2);
	}
	
	public String toString() {
		String str = "";
		return str;
	}
}
