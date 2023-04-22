package org.ishaan.sim;
import java.util.ArrayList;

public class PositionCalculator {
	//Variables
	private final int numObjects;
	private final int initialCircleSize;
	private ArrayList<SimObject> points = new ArrayList<SimObject>();
	
	//FINAL VARIABLES
	private final double POSITIONINCREMENT;
	private final int MOVLENGTH = 1;
	private final int SQUARESIDE = 5;
	
	public PositionCalculator() {
		this.numObjects = 2;
		this.initialCircleSize = 1;
		this.POSITIONINCREMENT = 360.0/numObjects;
	}

	public PositionCalculator(int numObjects, int sizeCircle) throws IllegalArgumentException {
		if(numObjects > 1 && sizeCircle > 0) {
			this.numObjects = numObjects;
			this.initialCircleSize = sizeCircle;
			this.POSITIONINCREMENT = 360.0/numObjects;
		}else {
			throw new IllegalArgumentException();
		}

	}

	public void assignStartPositions() {
		assignAngles();
		assignPositions(initialCircleSize);
	}
	
	public void assignAngles() {
		double position = POSITIONINCREMENT;
		for(int i = 0; i < numObjects; i++) {
			points.add(new SimObject(position));
			position += POSITIONINCREMENT;
		}
	}
	
	public void assignPositions(double stepSize) {
		for(int i = 0; i < numObjects; i++) {
			SimObject position = points.get(i); 
			double angle = position.getAngle();
			position.setxCoordinate(stepSize * Math.cos(Math.toRadians(angle)));
			position.setyCoordinate(stepSize * Math.sin(Math.toRadians(angle)));
		}
	}
	
	public void movePoints() {
		for(SimObject point : points) {
			//while(point.getxCoordinate() <= SQUARESIDE || point.getyCoordinate() <= SQUARESIDE) {
			//	point.setxCoordinate(point.getxCoordinate() + (Math.random() * MOVLENGTH));
			//	point.setyCoordinate(point.getyCoordinate() + (Math.random() * MOVLENGTH));
			//}
			
		}
	}
	
	public String toString() {
		String str = "numObjects: " + numObjects + "\nSize of the circle: " + 
					initialCircleSize + "\nPoints: ";
		int index = 1;
		for(SimObject point : points) {
			str += "\npoint #" + index + " angle measure " + point.getAngle() + ", ";
			str += "point # " + index + " X position: " + point.getxCoordinate() +
				   ", Y position: " + point.getyCoordinate();
			index++;
		}
		return str;
	}

	public int getNumObjects() {
		return numObjects;
	}


	public int getSizeCircle() {
		return initialCircleSize;
	}

	public ArrayList<SimObject> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<SimObject> points) {
		this.points = points;
	}

	public double getPOSITIONINCREMENT() {
		return POSITIONINCREMENT;
	}

	public int getMOVLENGTH() {
		return MOVLENGTH;
	}

	public int getSQUARESIDE() {
		return SQUARESIDE;
	}
}
