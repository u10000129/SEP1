package gradeSystem;
public class UI {
	GradeSystems gradeSystems;
	String curStudentID;
	
	UI() {
		gradeSystems = new GradeSystems();
	}
	
	public boolean checkCommand(String cmd) {
		if(cmd.toUpperCase().equals("G")) gradeSystems.showGrade(curStudentID);
		else if(cmd.toUpperCase().equals("R")) gradeSystems.showRank(curStudentID);
		else if(cmd.toUpperCase().equals("A")) gradeSystems.showAverages();
		else if(cmd.toUpperCase().equals("W")) gradeSystems.updateWeights();
		else if(cmd.toUpperCase().equals("E")) return false;
		else System.out.println("Input Command Wrong!");
		return true;
	}
	
	public boolean checkID(String studentID) {
		curStudentID = studentID;
		return gradeSystems.containID(studentID);
	}
	
	public void promptCommand() {
		System.out.println("Enter Command: 1).G - Show your grade");
		System.out.println("               2).R - Show your rank");
		System.out.println("               3).A - Show average grade of each exam");
		System.out.println("               4).W - Modify weight on each exam");
		System.out.println("               5).E - Exit Menn");
	}
	
	public void promptID() {
		System.out.print("Enter 'student ID' or 'Q' to quit System: ");
	}
	
	public void showFinishMsg() {
		System.out.println("System shut down.");
	}
	
	public void showWelcomeMsg() {
		System.out.println("Welcome "+gradeSystems.getStudentName(curStudentID));
	}
	
	public void showStudentIdWrongMsg() {
		System.out.println("Student ID dosen't exit in our System!");
	}
}
