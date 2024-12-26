package codeAlpha;

public class Array_Elements {
	/*
	 * This function is used to take the elements of an array, sum all the values of
	 * the array, and then calculate the average. Essentially, two tasks are
	 * performed within a class: first, taking all the array values, and second,
	 * calculating the average.
	 */

	public void gradesValues(int no_of_students, int[] gradesArray) {

		// for-loop to ask again and again for entering a student grade

		for (int i = 0; i < no_of_students; i++) {
			try {
				while (true) {
					System.out.print("Enter grades of student number " + (i + 1) + " :-  ");
					gradesArray[i] = Project_1.sc.nextInt();

					if (gradesArray[i] >= Project_1.min_limit && 
							gradesArray[i] <= Project_1.max_limit ) {
						break;
					} else {
						System.out.println();
						System.out.println("Grades can be between " +Project_1.min_limit 
								+" and " +Project_1.max_limit +".");
						System.out.println();
					}
				}

			} catch (Exception e) {
				System.out.println("Please Enter grades in integer form (like 1,2,3) :- ");
				Project_1.sc.next();
				i--;
			}
		}
	}
}