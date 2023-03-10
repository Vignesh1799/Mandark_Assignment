package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem 1: You are given two lists a and b of n positive integers each. You can apply the following swap operations to them any number of times.
 *Select an index i (1 <= i <= n) and swap ai with bi (i.e. ai becomes bi and vice versa).
 *Write a function minmax(a,b) which takes two lists a and b of size n as inputs and returns an integer, which is the minimum possible value of max(a1, a2, ..., a ) x max(b1,
 *b2, ..., b ) you can get after applying the swap operation any number of times (possibly zero).

 *Example - Consider that the list starts with index 0
 *Consider the lists : a = [1, 2, 6, 5, 1, 2] and b = [3, 4, 3, 2, 2, 5]

 *In this case, you can apply the swap operation at indices 1 (between 2 and 4) and
 *5 (between 2 and 5),
 *then a = [1, 4, 6, 5, 1, 5] and b = [3, 2, 3, 2, 2, 2]
 *and max(1, 4, 6, 5, 1, 5) x max (3, 2, 3, 2, 2, 2) = 6 x 3 = 18
*/

public class Problem1 {

	/*
	 * maxValue method - find the Maximum value of the input List.
	 * input -List<Integer> 
	 * return - int (Maximum Value among the List)
	 */

	public int maxValue(List<Integer> a) {
		int temp = 0;
		for (int i = 0; i < a.size(); i++) {
			temp = a.get(i) > temp ? a.get(i) : temp;
		}

		return temp;
	}

	/*
	 * minmax method - takes two lists a and b of size n as inputs and returns an
	 * integer, which is the minimum possible value of max(a1, a2, ..., a ) x
	 * max(b1, b2, ..., b ) you can get after applying the swap operation any number
	 * of times (possibly zero).
	 * 
	 * input - List<Integer> and List<Integer> return - int ( minimum possible value
	 * of max(List 1) x max(List 2) )
	 */
	public int minmax(List<Integer> l1, List<Integer> l2) {

		int maxL1 = maxValue(l1), maxL2 = maxValue(l2), max = 0;
		/*
		 * Finding the list which have maximum value and avoid them for futher analysis
		 * (l3) then the another List is opted for operation (l4) So, l4 should be
		 * processed to get desired output
		 */
		List<Integer> l3 = maxL1 >= maxL2 ? l1 : l2;
		List<Integer> l4 = maxL1 >= maxL2 ? l2 : l1;
		// maximum value of l4 is swapped with l3 at specific index if value is lesser.
		do {
			max = maxValue(l4);

			for (int i = 0; i < l1.size(); i++) {
				if (l4.get(i) == max && l4.get(i) > l3.get(i)) {
					int temp = l4.get(i);
					l4.set(i, l3.get(i));
					l3.set(i, temp);
				}

			}
		} while (maxValue(l4) != max);

		// if all max value is swapped, again loops to the next maximum value (or)
		// loop exists and return the calculated result

		return maxValue(l3) * max;
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 6, 5, 1, 2));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(3, 4, 3, 2, 2, 5));
		Problem1 p = new Problem1();
		System.out.println(p.minmax(l1, l2));
	}

}