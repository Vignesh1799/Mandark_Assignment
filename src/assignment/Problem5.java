package assignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*Problem 5: A perfect number is a positive integer that is equal to the sum of its proper divisors (excluding itself). Write a program that checks whether the input integer is perfect or not.
 *It should return true if the number is perfect. Otherwise it should return false.
 *
 *Sample Input 1
 * 8
 *Output
 * false
 * */

public class Problem5 {
	/*
	 * perfectNumber method check whether the input number is perfect or not. Then i
	 * will return true or false based upon checking. input - int (Number) return -
	 * boolean (true or false - depends on the condition)
	 */
	public boolean perfectNumber(int number) {
		int sum = 0;
		Set<Integer> divisors = new HashSet<>();
		/*
		 * HashSet is created to store the Divisor values. Hashset used for 2 reasons:
		 * 1. doesn't know the length of the divisor 2. The divisor values shouldn't
		 * repeat (unique)
		 */

		for (int i = 1; i <= number / 2; i++) {

			if (number % i == 0) {
				divisors.add(i);
				divisors.add(number / i);
			}
		}
		// Any number is divisible by its own number, So we remove them from the set
		divisors.remove(number);

		// Once we got all Divisor, we iterate to get sum.
		Iterator<Integer> it = divisors.iterator();
		while (it.hasNext()) {
			sum += (int) it.next();
		}

		return sum == number ? true : false;
	}

	public static void main(String[] args) {
		int number = 28;
		Problem5 p = new Problem5();
		System.out.println(p.perfectNumber(number));
	}
}
