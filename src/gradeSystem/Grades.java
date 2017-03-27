package gradeSystem;
public class Grades {
	String name;
	String ID;
	int[] gradeList;
	int totalGrade;
	
	/**Constructor Usage
	 * construct and initialize a structure to store students' grade.
	 * 
	 * @param ID - ID for the student.
	 * @param name - name for the student.
	 * @param lab1 - lab1 for the student.
	 * @param lab2 - lab2 for the student.
	 * @param lab3 - lab3 for the student.
	 * @param midTerm - midTerm for the student.
	 * @param finalExam - finalExam for the student.
	 * 
	 * pseudo code: 
	 * 1.Initialize parameters, including ID, name, and five grades.
	 * 2.The five grades are store in a list called gradeList.
	 * 
	 * Time estimate: O(1), constant time to initialize a student's information. 
	 */
	public Grades(String ID, String name, int lab1, int lab2, int lab3, int midTerm, int finalExam) {
		this.ID = ID;
		this.name = name;
		gradeList = new int[5];
		gradeList[0] = lab1; 
		gradeList[1] = lab2;
		gradeList[2] = lab3;
		gradeList[3] = midTerm;
		gradeList[4] = finalExam;
	}
	
	/** calculateTotalGrade usage 
	 * calculate the total grade of the student.
	 * 
	 * @param weights
	 * @return totalGrade
	 * 
	 * pseudo code: 
	 * 1.all five grades are multiplied with their weight.
	 * 2.sum up all weighted grades.
	 * 
	 * Time estimate: O(1), constant time to calculate a total grade.
	 */
	public int calculateTotalGrade(float[] weights) {
		float temp = 0;
		for(int i=0;i<5;i++) temp += gradeList[i]*weights[i];
		totalGrade = Math.round(temp);
		return totalGrade;		
	}

}
