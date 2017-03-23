package gradeSystem;
public class Grades {
	String name;
	String ID;
	int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	Grades(String ID, String name, int lab1, int lab2, int lab3, int midTerm, int finalExam) {
		this.ID = ID;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
	}
	
	public int calculateTotalGrade(float[] weights) {
		totalGrade =	Math.round(lab1*weights[0]+
						lab2*weights[1]+
						lab3*weights[2]+
						midTerm*weights[3]+
						finalExam*weights[4]);
		return totalGrade;		
	}

}
