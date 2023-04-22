package org.ishaan.sim;

import java.util.ArrayList;

import org.ishaan.sim.SimObject.orientation;

public class PositionCalculator {
	// Variables
	private final int numObjects;
	private final int initialCircleSize;
	private ArrayList<SimObject> points = new ArrayList<SimObject>();

	// FINAL VARIABLES
	private final double POSITIONINCREMENT;
	private final double MOVLENGTH = 1;
	private final double SQUARESIDE = 10;
	private final double HALFSQUARESIDE = SQUARESIDE / 2;

	public PositionCalculator() {
		this.numObjects = 2;
		this.initialCircleSize = 1;
		this.POSITIONINCREMENT = 360.0 / numObjects;
	}

	public PositionCalculator(int numObjects, int sizeCircle) throws IllegalArgumentException {
		if (numObjects > 1 && sizeCircle > 0) {
			this.numObjects = numObjects;
			this.initialCircleSize = sizeCircle;
			this.POSITIONINCREMENT = 360.0 / numObjects;
		} else {
			throw new IllegalArgumentException();
		}

	}

	public void assignPositions() {
		initializeAngles();
		initializePositions(initialCircleSize);
		initializeOrientation();
		System.out.println(toString());
		for (int i = 0; i < 100; i++) {
			movePoints();
			try {
				Thread.sleep(1000);
				printCurrentPositions();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void initializeAngles() {
		double position = POSITIONINCREMENT;
		for (int i = 0; i < numObjects; i++) {
			points.add(new SimObject(position));
			position += POSITIONINCREMENT;
		}
	}

	public void initializeOrientation() {
		int index = 1;
		for (SimObject point : points) {
			if (point.getyCoordinate() > 0) {
				point.setDirection(orientation.UP);
			} else if (point.getyCoordinate() < 0) {
				point.setDirection(orientation.DOWN);
			} else if (point.getxCoordinate() > 0 && point.getyCoordinate() == 0) {
				point.setDirection(orientation.RIGHT);
			} else if (point.getxCoordinate() < 0 && point.getyCoordinate() == 0) {
				point.setDirection(orientation.LEFT);
			}
			point.setName(index++ + "");
		}
	}

	public void initializePositions(double stepSize) {
		for (int i = 0; i < numObjects; i++) {
			SimObject position = points.get(i);
			double angle = position.getAngle();
			position.setxCoordinate(stepSize * Math.cos(Math.toRadians(angle)));
			position.setyCoordinate(stepSize * Math.sin(Math.toRadians(angle)));
		}
	}

	public void movePoints() {
		for (SimObject point : points) {
			// while(point.getxCoordinate() <= SQUARESIDE || point.getyCoordinate() <=
			// SQUARESIDE) {
			// point.setxCoordinate(point.getxCoordinate() + (Math.random() * MOVLENGTH));
			// point.setyCoordinate(point.getyCoordinate() + (Math.random() * MOVLENGTH));
			// }
			double angleOfMovement = calculateAngleOfMovement(point);

			double xMovement = Math.cos(Math.toRadians(angleOfMovement));
			double yMovement = Math.sin(Math.toRadians(angleOfMovement));
			point.setxCoordinate(xMovement + point.getxCoordinate());
			point.setyCoordinate(yMovement + point.getyCoordinate());
			point.setAngle(angleOfMovement);
			if (checkForBoundary(point)) {
				bounce(point);
			}
		}
	}

	private double calculateAngleOfMovement(SimObject point) {
		double angleOfMovement;
		if (point.getDirection().equals(orientation.UP)) {
			angleOfMovement = Math.random() * 181;
		} else if (point.getDirection().equals(orientation.DOWN)) {
			angleOfMovement = (Math.random() * 181) + 180;
		} else if (point.getDirection().equals(orientation.RIGHT)) {
			angleOfMovement = (Math.random() * 181) + 90;
		} else if (point.getDirection().equals(orientation.LEFT)) {
			angleOfMovement = (Math.random() * 181) + 270;
		} else {
			angleOfMovement = -1;
		}
		return angleOfMovement;
	}

	public boolean checkForBoundary(SimObject point) {
		if (point.getxCoordinate() >= HALFSQUARESIDE || point.getxCoordinate() <= (HALFSQUARESIDE * -1)
				|| point.getyCoordinate() >= HALFSQUARESIDE || point.getyCoordinate() <= (HALFSQUARESIDE * -1)) {
			return true;
		}
		return false;
	}

	public void bounce(SimObject point) {
		// X COORDINATES
		if (point.getxCoordinate() > HALFSQUARESIDE) {
			point.setxCoordinate((HALFSQUARESIDE - point.getxCoordinate()) + HALFSQUARESIDE);
		} else if (point.getxCoordinate() < (HALFSQUARESIDE * -1)) {
			point.setxCoordinate(((HALFSQUARESIDE * -1) - point.getxCoordinate()) - HALFSQUARESIDE);
		}

		// Y COORDINATES
		if (point.getyCoordinate() > HALFSQUARESIDE) {
			point.setyCoordinate((HALFSQUARESIDE - point.getyCoordinate()) + HALFSQUARESIDE);
		} else if (point.getyCoordinate() < (HALFSQUARESIDE * -1)) {
			point.setyCoordinate(((HALFSQUARESIDE * -1) - point.getyCoordinate()) - HALFSQUARESIDE);
		}
		flipOrientation(point);
		System.out.println("BOUNCED #" + point.getName());
	}

	private void flipOrientation(SimObject point) {
		if (point.getDirection().equals(orientation.UP)) {
			point.setDirection(orientation.DOWN);
		} else if (point.getDirection().equals(orientation.DOWN)) {
			point.setDirection(orientation.UP);
		} else if (point.getDirection().equals(orientation.RIGHT)) {
			point.setDirection(orientation.LEFT);
		} else if (point.getDirection().equals(orientation.LEFT)) {
			point.setDirection(orientation.RIGHT);
		}
	}

	public String toString() {
		String str = "numObjects: " + numObjects + "\nSize of the circle: " + initialCircleSize + "\nPoints: ";
		for (SimObject point : points) {
			str += "\npoint #" + point.getName() + " angle measure " + point.getAngle() + ", ";
			str += "point # " + point.getName() + " X position: " + point.getxCoordinate() + ", Y position: " + point.getyCoordinate();
		}
		return str;
	}

	public void printCurrentPositions() {
		String str = "\n";
		for (SimObject point : points) {
			str += "\npoint #" + point.getName() + " angle measure " + point.getAngle() + ", ";
			str += "point # " + point.getName() + " X position: " + point.getxCoordinate() + ", Y position: " + point.getyCoordinate();
		}
		System.out.println(str);
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

	public double getMOVLENGTH() {
		return MOVLENGTH;
	}

	public double getSQUARESIDE() {
		return SQUARESIDE;
	}
}
