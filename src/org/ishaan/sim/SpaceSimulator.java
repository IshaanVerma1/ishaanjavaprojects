package org.ishaan.sim;

public class SpaceSimulator {
	private SpaceObject[] objects = new SpaceObject[2];
	private double distanceX;//distance on x axis
	private double distanceY;//distance on y axis
	//private double distance;//distance between spaceObjects
	private final double GRAVCONSTANT = (6.67 * Math.pow(10, -11));
	
	public SpaceSimulator() {
		objects[0] = new SpaceObject(); objects[1] = new SpaceObject();
		objects[0].setXCoordinate(-(100/2));objects[1].setXCoordinate(100/2);
		objects[0].setObjNum(0);objects[1].setObjNum(1);
		//this.distance = Math.sqrt(Math.pow(objects[1].getXCoordinate()-objects[0].getXCoordinate(), 2) + Math.pow(objects[1].getYCoordinate()-objects[0].getYCoordinate(), 2));
	}
	
	public SpaceSimulator(double speedInKM, long weightInKG, double speedInKM2, long weightInKG2, double distanceX, double distanceY) {
		objects[0] = new SpaceObject(speedInKM, weightInKG); objects[1] = new SpaceObject(speedInKM2, weightInKG2);
		this.distanceX = distanceX;
		this.distanceY = distanceY;
		objects[0].setObjNum(0);objects[1].setObjNum(1);
		objects[0].setXCoordinate(-(distanceX/2));objects[1].setXCoordinate(distanceX/2);
		objects[0].setYCoordinate(-(distanceY/2));objects[1].setYCoordinate(distanceY/2);
	}
	
	public void simulate(int seconds) {
		for(int i = 0; i < seconds; i++) {
			System.out.println("#" + (i + 1));
			System.out.println("Object 1: \n" + objects[0].toString());
			System.out.println("Object 2: \n" + objects[1].toString());
			for(SpaceObject obj : objects) {
				calculateNewPosX(obj);
				calculateNewPosY(obj);
			}
		}
		
		//Thread.sleep(1000);
	}
	
	public double calculateGravitalForce(){
		return (GRAVCONSTANT * (objects[0].getWeightInKG() * 1000) * (objects[1].getWeightInKG() * 1000))/Math.pow(findDistance(), 2);
	}
	
	public double findDistance() {
		return Math.sqrt(Math.pow(objects[1].getXCoordinate()-objects[0].getXCoordinate(), 2) + Math.pow(objects[1].getYCoordinate()-objects[0].getYCoordinate(), 2));
	}
	
	public void calculateNewPosX(SpaceObject object){
		double gravityX = calculateGravitalForce() * getCosTheta(object);
		double acceleration = gravityX/(object.getWeightInKG() * 1000);
		double distanceX = object.getVelocityX() + .5*acceleration;
		object.setVelocityX(object.getVelocityX() + acceleration);
		object.setXCoordinate(distanceX + object.getXCoordinate());
	}
	
	public void calculateNewPosY(SpaceObject object) {
		double gravityY = calculateGravitalForce() * getSinTheta(object);
		double acceleration = gravityY/(object.getWeightInKG() * 1000);
		double distanceY = object.getVelocityY() + .5 * acceleration;
		object.setVelocityY(object.getVelocityY() + acceleration);//velocity
		object.setYCoordinate(distanceY + object.getYCoordinate());
	}
	
	public double getSinTheta(SpaceObject obj) {
		SpaceObject reference = obj;
		int refNum = reference.getObjNum();
		SpaceObject target;
		if(refNum == 0) {
			target = objects[1];
		} else {
			target = objects[0];
		}
		return (target.getYCoordinate() - reference.getYCoordinate()) / findDistance();//o/h
	}
	
	public double getCosTheta(SpaceObject obj) {
		SpaceObject reference = obj;
		int refNum = reference.getObjNum();
		SpaceObject target;
		if(refNum == 0) {
			target = objects[1];
		} else {
			target = objects[0];
		}
		return (target.getXCoordinate() - reference.getXCoordinate()) / findDistance();//a/h
	}
	
	public String toString() {
		String str = "";
		return str;
	}
}
