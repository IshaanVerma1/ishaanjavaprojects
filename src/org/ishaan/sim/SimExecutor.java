package org.ishaan.sim;
public class SimExecutor {
	public static void main(String[] args) {

//		System.out.println(Math.cos(Math.toRadians(144)));
//		System.out.println(Math.sin(Math.toRadians(144)));
		PositionCalculator program = new PositionCalculator(4, 1);
		program.assignPositions();
		//System.out.println(program.toString());
		//System.out.println("\n"+program.toString());
	}
}
