package gradeSystem;
public class Grades {
	String name;
	String ID;
	int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	
	public Grades(String name, String ID, int lab1, int lab2, int lab3, int midTerm, int finalExam) {
		this.name = name;
		this.ID = ID;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
	}
	
	public int calculateTotalGrade() {
		totalGrade = lab1+lab2+lab3+midTerm+finalExam;
		return totalGrade;		
	}

}
