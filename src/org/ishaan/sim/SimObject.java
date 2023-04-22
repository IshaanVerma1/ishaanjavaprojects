package org.ishaan.sim;
import java.text.DecimalFormat;

public class SimObject {
	private String name;
	private double angle;
	private double xCoordinate;
	private double yCoordinate;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	enum orientation{
		UP,
		RIGHT,
		DOWN,
		LEFT,
	}
	private orientation direction;

	public orientation getDirection() {
		return direction;
	}

	public void setDirection(orientation direction) {
		this.direction = direction;
	}
	
	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = Double.parseDouble(df.format(xCoordinate));
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = Double.parseDouble(df.format(yCoordinate));
	}

		public SimObject(double angle) {
		this.angle = angle;
	}
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = Double.parseDouble(df.format(angle));
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
