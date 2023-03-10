package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Problem 3: Write a program that takes a list of unique strings as an argument,
 * where each string is a combination of a letter from a - z and a number from 0 - 99 ,
 * the initial character in string being the letter. For example a23, d5, z0, q99 are some strings in this format.
 * The program should sort the list and return the lists L1 and L2 in the order mentioned below.
 * 
 * L1 : First list should contain all strings sorted in ascending order with respect to the first character only.
 * All the strings with the same initial character should be in the same order as in the original list.
 * 
 * L2 : In the list L1 above, sort the strings starting with the same character,
 * in descending order with respect to the number formed by the remaining characters.
 * 
 * Note - Have used Bubble Sort Algorithm for sorting purpose.
 * */

public class Problem3 {
	/*
	 * conditionList1 - Satisfy First List condition - Lists were ordered in
	 * ascending only by the first letter. And need to be in same insertion order,
	 * if first letters were similar
	 * 
	 * input - List<String> (Input List)
	 * return - List<String>(Sorted list based on First condition)
	 */
	public List<String> conditionList1(List<String> l) {

		/*
		 * 1st For loop - Pass in bubble sort. In Bubble sort, have to pass "n-1" time,
		 * where n is the no. of items to be sorted.
		 * Note: sortCheck - check whether previous pass is sorted or not. If previous pass not sorted, then we will end
		 * sorting.
		 */
		for (int i = 0; i < l.size() - 1; i++) {
			int sortCheck = 0;

			// 2nd For loop - Sort adjacent String objects(Bubble Sort) in list based on the condition 1
			for (int j = 0; j < l.size() - 1; j++) {
				String single1 = Character.toString(l.get(j).charAt(0));
				String single2 = Character.toString(l.get(j + 1).charAt(0));

				if (single1.compareTo(single2) > 0) {
					String temp = l.get(j);
					l.set(j, l.get(j + 1));
					l.set(j + 1, temp);
					sortCheck++;
				}
			}
			if (sortCheck == 0) {
				break;
			}
		}
		return l;

	}
	/*
	 * conditionList 2 - Satisfy Second List condition - First ordered lists were
	 * again ordered in descending, based on the numbers present in the 1st and 2nd
	 * index of each string
	 * 
	 * input - List<String> (Sorted List 1)
	 * return - List<String>(Sorted list based on Second condition)
	 */

	public List<String> conditionList2(List<String> l) {
		/*
		 * 1st For loop - Pass in bubble sort. In Bubble sort, have to pass "n-1" time,
		 * where n is the no. of items to be sorted. Note: sortCheck - check whether
		 * previous pass is sorted or not. If previous pass not sorted, then we will end
		 * sorting.
		 */
		try {
			for (int i = 0; i < l.size() - 1; i++) {
				int sortCheck = 0;
				for (int j = 0; j < l.size() - 1; j++) {
					if (l.get(j).charAt(0) == l.get(j + 1).charAt(0)) {
						int no1 = Integer.parseInt(l.get(j).substring(1));
						int no2 = Integer.parseInt(l.get(j + 1).substring(1));
						if (no1 < no2) {
							String temp = l.get(j);
							l.set(j, l.get(j + 1));
							l.set(j + 1, temp);
							sortCheck++;
						}
					}

				}
				if (sortCheck == 0) {
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("input String doesn't meet the conditions");
			System.exit(0);

		}
		return l;
	}

	public static void main(String[] args) {

		List<String> nameList = new ArrayList<>(
				Arrays.asList("d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77"));
		
		Problem3 p = new Problem3();

		List<String> output1 = p.conditionList1(nameList);
		System.out.println("L1 : " + output1);
		List<String> output2 = p.conditionList2(output1);
		System.out.println("L2 : " + output2);
	}

}