package assignment;

/*
 *Problem 4: The below image represents a grid having 11x11 nodes numbered from 0 to 10.
 *● Distance between one node to the next connected node is 1 unit.
 *● One can go in any direction, each letter counts as 1 unit in each direction.
 *
 *● N North
 *● S South
 *● E East
 *● W West
 *
 *The below graph shows the path of “NNNNEEENE” starting from (0,0)
 *Write a program to take
 *● a start point as an array containing two elements as x and y coordinate, 
 *and a string as input from the user and print the shortest distance between the start and end point.
 * 
 * Sample Input 
 * [0, 0]
 * NNNNEEENE
 * Output
 * 6.4 [Hint : √((4-0)2 + (5-0)2) = 6.4]
 */

public class Problem4 {

	/*
	 * shortDistance method - find the shorted distance between the starting and
	 * ending point of movement. input - int x(Starting x point), int y (Starting x
	 * point), String path (Path travelled) return - double (Shortest distance - in
	 * terms of Units)
	 */
	public static double shortDistance(int x, int y, String path) {

		// it perform operation based on the individual character of the string,
		// if String doesn't meet the criteria, i will show error message and exits.

		int initialX = x, initialY = y;

		for (int i = 0; i < path.length(); i++) {
			char tempCh = path.charAt(i);
			if (tempCh == 'N')
				y++;
			else if (tempCh == 'S')
				y--;
			else if (tempCh == 'W')
				x--;
			else if (tempCh == 'E')
				x++;
			else {
				System.out.println("Wrong input String format");
				System.exit(0);
			}
		}
		return Math.sqrt((Math.pow(x - initialX, 2)) + (Math.pow(y - initialY, 2)));
	}

	public static void main(String[] args) {

		int xStartPoint = 0;
		int yStartPoint = 0;
		String path = "NNNNEEENE";

		double shortDist = shortDistance(xStartPoint, yStartPoint, path);

		System.out.println(Math.round(shortDist * 10.0) / 10.0);
	}
}