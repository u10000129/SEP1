package gradeSystem;
public class Grades {
	String name;
	String ID;
	int[] gradeList;
	int totalGrade;
	

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
	
	public int calculateTotalGrade(float[] weights) {
		float temp = 0;
		for(int i=0;i<5;i++) temp += gradeList[i]*weights[i];
		totalGrade = Math.round(temp);
		return totalGrade;		
	}

}
