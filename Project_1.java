/*	TASK 1 :- Student Grade Tracker:	
 *  Develop a program that allows a teacher to enter
 *	students' grades and compute their average,
 *	highest, and lowest scores. You can use arrays or
 *	ArrayLists to store the student data.			*/

package codeAlpha;

import java.util.Scanner;

public class Project_1 {

	public static Scanner sc = new Scanner(System.in);
	
	static final int min_limit = 0;
	static final int max_limit = 100;
	
	public static void main(String[] args) {

		// ==>> Declaring variables

		int no_of_students = 0;
		int lowest = 0;
		float average = 0;
		int highest = 0;
		int option = 0;

		while (true) {
			System.out.println("Do you want to evaluate the students grades :- ");
			System.out.println("Press 1 for YES.");
			System.out.println("Press 0 for NO.");

		try {
			option = sc.nextInt();
			while (true) {
				if (option == 0) {
					
					sc.close();
					System.out.println("Exiting the program. Thank You!");
					System.exit(1);
						
				} else if (option == 1) {
					
					// ==>> function to take valid input of total number of students
					no_of_students = totalStudents(no_of_students);

					while (true) {
						if (no_of_students == 0) {
							System.out.println("There's no student found to calculate grades.");
							System.out.println("===========================================================");
							System.out.println();
							break;
						} else {
							
							// ==>> using an array to store grades of students
							int[] gradesArray = new int[no_of_students];
							System.out.println();
							
							// ==>> Making Array_Elements class object
							Array_Elements a = new Array_Elements();

							// ==>> Calling Array_Elements class's method
							a.gradesValues(no_of_students, gradesArray);

							// ==>> function to Show the grades of each student
							displayGrades(gradesArray);

							// ==>> function to show the calculated values of lowest , highest and average	
							displayStatistics(gradesArray, lowest, highest, average, no_of_students);

							break;
						}
					}
				} else {
					System.out.println("only '0' and '1' are allowed.");
					System.out.println();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Please enter integer type value (like 1,2,3).");
			sc.next();
		}
	}
}

	/*
	 * This is a function used to determine how many students' grades will be
	 * included. In other words, we need to find out the total number of students so
	 * that we can know how many grades need to be entered.
	 */

	private static int totalStudents(int no_of_students) {
		System.out.println("How many student's grades do you want to keep ? ");

		/*
		 * try-catch block handles invalid input by displaying an error message, and a
		 * while loop ensures the program keeps requesting valid input until it is
		 * received.
		 */

		while (true) {
			try {
				
				// input prompt for entering total number of students
				no_of_students = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println();
				System.out.print("Please Enter number in integer form (like 1,2,3) :- ");
				sc.next();
			}
		}
		return no_of_students;
	}

	/*
	 * This function is used to determine the student number, indicating which
	 * student it is. Then, their corresponding grades will be displayed to show how
	 * many marks they have.
	 */

	private static void displayGrades(int[] grades_array) {
		System.out.println();
		System.out.println("Student Number  ==>>   Grade");
		System.out.println();

		// for-loop to display student number & their grades respectively

		for (int i = 0; i < grades_array.length; i++) {
			System.out.println("|_____" + (i + 1) + "______|  ==>>  " + "|__" + grades_array[i] + "__|");
		}
	}

	/*
	 * In this function, we store the first values of the array in lowest and
	 * highest and then compare them with the entire list to find the smallest and
	 * largest values. After that, we assign these values to lowest and highest,
	 * print them, and then display these values along with the average for the
	 * user.
	 */

	private static void displayStatistics(int[] grades_array, int lowest, int highest, float average, int no_of_students) {

		lowest = grades_array[0];
		highest = grades_array[0];
		average = grades_array[0];
		
		for (int i = 1; i < grades_array.length; i++) {

			if (lowest > grades_array[i]) {
				lowest = grades_array[i];
			}


			if (highest < grades_array[i]) {
				highest = grades_array[i];
			}
			
			average += grades_array[i];
			average =  average/no_of_students;
		}
		// Displaying actual results

		System.out.println();
		System.out.println("Highest Grade :- " + highest);
		System.out.println("Average Grade :- " + average);
		System.out.println("Lowest Grade :- " + lowest);
		System.out.println();
		System.out.println("===========================================================");
		System.out.println();
	}
}