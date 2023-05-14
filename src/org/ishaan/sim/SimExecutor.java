package org.ishaan.sim;

import java.util.Scanner;

public class SimExecutor {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to simulate random positions on a circle, or 2 meteroids heading towards eachother?\nenter 1 for the first option, 2 for the second option.");
		String userProgram = input.nextLine();
		if(userProgram.equals("1")) {
			System.out.println("How many positions do you want on the circle?");
			int positions = input.nextInt();
			System.out.println("How large do you want the circle?");
			int size = input.nextInt();
			PositionCalculator program = new PositionCalculator(positions, size);
			program.assignPositions();
		} else if (userProgram.equals("2")) {
			//double speedInKM, long weightInKG, double speedInKM2, long weightInKG2, double distanceX, double distanceY
			System.out.println("How fast do you want the first meteroid to be? (km per second, positive numbers only)");
			double velocity1 = input.nextInt();
			System.out.println("How heavy do you want the first meteroid to be? (weight in tonnes)");
			long weight1 = input.nextLong();
			System.out.println("How fast do you want the second meteroid to be? (km per second, positive numbers only)");
			double velocity2 = input.nextInt();
			System.out.println("How heavy do you want the second meteroid to be? (weight in tonnes)");
			long weight2 = input.nextLong();
			System.out.println("How far on the x axis do you want the meteroids to be? (km)");
			double distanceX = input.nextInt();
			System.out.println("How far on the y axis do you want the meteroids to be? (km)");
			long distanceY = input.nextLong();
			SpaceSimulator sim = new SpaceSimulator(velocity1, weight1, -velocity2, weight2, distanceX, distanceY);
			System.out.println("How many times do you want the program to run?");
			int amount = input.nextInt();
			sim.simulate(amount);
		}
		input.close();
	}
}
