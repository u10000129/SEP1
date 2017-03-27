package gradeSystem;
public class UI {
	GradeSystems gradeSystems;
	String curStudentID;
	
	/**Constructor Usage
	 * construct a grade system.
	 */
	public UI() {
		gradeSystems = new GradeSystems();
	}
	
	/** CheckCommand Usage
	 * @param cmd - the command user input (G, R, A, W or E).
	 * @return false - if user want to log out. 
	 */
	public boolean checkCommand(String cmd) {
		if(cmd.toUpperCase().equals("G")) gradeSystems.showGrade(curStudentID);
		else if(cmd.toUpperCase().equals("R")) gradeSystems.showRank(curStudentID);
		else if(cmd.toUpperCase().equals("A")) gradeSystems.showAverages();
		else if(cmd.toUpperCase().equals("W")) gradeSystems.updateWeights();
		else if(cmd.toUpperCase().equals("E")) return false;
		else System.out.println("Input Command Wrong!");
		return true;
	}
	
	/** checkID usage
	 * @param studentID - the student ID user used to log in.
	 * @return whether student ID exist in system.
	 */
	public boolean checkID(String studentID) {
		curStudentID = studentID;
		return gradeSystems.containID(studentID);
	}
	
	/** promptCommand
	 * Indicate user there are 5 command available (G, R, A, W or E)
	 */
	public void promptCommand() {
		System.out.println("Support Command: 1).G - Show your grade");
		System.out.println("                 2).R - Show your rank");
		System.out.println("                 3).A - Show average grade of each exam");
		System.out.println("                 4).W - Modify weight on each exam");
		System.out.println("                 5).E - Exit Menu");
	}
	
	/** promptID usage
	 * indicate user use ID to log in or quit system.
	 */
	public void promptID() {
		System.out.print("Enter 'student ID' to log in or 'Q' to quit System: ");
	}
	
	/** showFinishMsg Usage
	 * print out finish message.
	 */
	public void showFinishMsg() {
		System.out.println("System shut down.");
	}
	
	/** showWelcomeMsg Usage
	 * Welcome user who log in.
	 */
	public void showWelcomeMsg() {
		System.out.println("Welcome "+gradeSystems.getStudentName(curStudentID));
	}
	
	/** showStudentIdWrondMsg
	 * Tell user the input student ID is wrong.
	 */
	public void showStudentIdWrongMsg() {
		System.out.println("Student ID dosen't exit in our System!");
	}
}
