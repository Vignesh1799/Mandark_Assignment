package assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Problem 2: Each line in the file employees.csv contains the full name, role and division of employees separated by a comma.
 * Every line corresponds to one employee.
 * The user wants to collect the details of :
 * 1. Employees who are managers in the R&D division. 
 * 	  For managers the string for the role is ‘Manager’ and 
 *    the division string for employees working in the R&D division is ‘R&D’.
 * 2. Employees who do not have last names. 
 * The name is a combination of first and last name, separated by a space.
 * 
 * Write a program to collect the required details and write the output into files managers.csv and single_name_employees.csv.
 * Assume that the employees.csv is present in the present working directory and generate the output in the same directory.
 * */
/*
 * ManagersCSV method - find the employee who is manager in R&D and stores the
 * data in manager.csv file. input - List<Employee> (contains the list of
 * employees) return - void (stores the data in managers.csv)
 */

public class Problem2 {

	/*
	 * ManagersCSV method - find the employee who is manager in R&D and stores the
	 * data in manager.csv file. input - List<Employee> (contains the list of
	 * employees) return - void (stores the data in managers.csv)
	 */
	public static void managersCSV(List<Employee> l) {

		// the managers.csv file is created and fetched the values that follows the 1st
		// condition.
		File managersCSV = new File("managers.csv");

		try (FileWriter fw = new FileWriter(managersCSV); BufferedWriter bw = new BufferedWriter(fw);) {

			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getRole().equals("Manager") && l.get(i).getDivision().equals("R&D")) {
					bw.write(l.get(i).getName() + ", " + l.get(i).getRole() + ", " + l.get(i).getDivision());
					bw.newLine();
				}
			}
			System.out.println("The manager.csv file is updated");
		} catch (IOException e) {
			System.out.println("Error while writing data to manager.csv file");
			System.out.println(e);
		}
	}

	/*
	 * singleNameEmployessCSV method - find the employee who has single name and
	 * stores the data in single_name_employees.csv file. input - List<Employee>
	 * (contains the list of employees) return - void (stores the data in
	 * single_name_employees.csv)
	 */

	public static void singleNameEmployessCSV(List<Employee> l) {

		File singleNameEmployeesCSV = new File("single_name_employees.csv");

		try (FileWriter fw = new FileWriter(singleNameEmployeesCSV); BufferedWriter bw = new BufferedWriter(fw);) {
			for (int i = 0; i < l.size(); i++) {

				if (!(l.get(i).getName().contains(" "))) {
					bw.write(l.get(i).getName() + ", " + l.get(i).getRole() + ", " + l.get(i).getDivision());
					bw.newLine();
				}
			}
			System.out.println("The single_name_employees.csv file is updated");
		} catch (IOException e) {
			System.out.println("Error while writing data to single_name_employees.csv file");
			System.out.println(e);
		}
	}

	// main method - Will obtain values from employees.csv file and store them in
	// the List<Employee>
	public static void main(String[] args) {

		try (Scanner s = new Scanner(new File("employees.csv"));) {
			s.useDelimiter(",");
			s.nextLine();
			List<Employee> employees = new ArrayList<>();
			while (s.hasNext()) {
				Employee e = new Employee();
				e.setName(s.next().trim());
				e.setRole(s.next().trim());
				e.setDivision(s.nextLine().replace(",", "").trim());
				employees.add(e);
			}
			System.out.println("The following processes were completed :");
			managersCSV(employees);
			singleNameEmployessCSV(employees);
		} catch (IOException e) {
			System.out.println("Error in handling input file from employees.csv");
			System.out.println(e);
		}

	}

}

/*
 * Employee Class stores the details of the employee that is fetched from
 * employee.csv It is an Encapsulated class that stores name, role and division
 * of the employee. getter and setter methods were to get and fetch data
 * respectively.
 */
class Employee {

	private String name;
	private String role;
	private String division;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

}