package gradeSystem;
public class UI {
	GradeSystems gradeSystems;
	String curStudentID;
	
	/**Constructor Usage
	 * construct a grade system.
	 * 
	 * pseudo code: 
	 * 1.construct a new grade system.
	 * 
	 * Time estimate: O(N), N for number of students.
	 */
	public UI() {
		gradeSystems = new GradeSystems();
	}
	
	/** CheckCommand Usage
	 * @param cmd - the command user input (G, R, A, W or E).
	 * @return false - if user want to log out. 
	 * 
	 * pseudo code: 
	 * 1. If cmd equals to G, ask gradeSystems to showGrade(curStudentID), and return true.
	 * 2. If cmd equals to R, ask gradeSystems to showRank(curStudentID), and return true.
	 * 3. If cmd equals to A, ask gradeSystems to showAverage(), and return true.
	 * 4. If cmd equals to W, ask gradeSystems to updateWeights(curStudentID), and return true.
	 * 5. If cmd equals to E, return false.
	 * 6. Else, show "Input Command Wrong!" and return true.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input E, return false.
	 */
	public boolean checkCommand(String cmd) {
		if(cmd.toUpperCase().equals("G")) gradeSystems.showGrade(curStudentID);
		else if(cmd.toUpperCase().equals("R")) gradeSystems.showRank(curStudentID);
		else if(cmd.toUpperCase().equals("A")) gradeSystems.showAverages();
		else if(cmd.toUpperCase().equals("W")) gradeSystems.updateWeights();
		else if(cmd.toUpperCase().equals("E")) return false;
		else System.out.println("Input Command Wrong! - "+cmd);
		return true;
	}
	
	/** checkID usage
	 * @param studentID - the student ID user used to log in.
	 * @return whether student ID exist in system.
	 * 
	 * pseudo code: 
	 * 1. Record current log-in student ID.
	 * 2. Ask gradeSystems to do containID(studentID).
	 *    Return true if student ID exist in system, otherwise return false.
	 *    
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input 555, return false. 
	 */
	public boolean checkID(String studentID) {
		curStudentID = studentID;
		return gradeSystems.containID(studentID);
	}
	
	/** promptCommand
	 * Indicate user there are 5 command available (G, R, A, W or E)
	 *
	 * pseudo code: 
	 * 1. Print out command message.
	 *    
	 * Time estimate: O(1).
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
	 * 
	 * pseudo code: 
	 * 1. Print out welcome message.
	 *    
	 * Time estimate: O(1).
	 */
	public void promptID() {
		System.out.print("Enter 'student ID' to log in or 'Q' to quit System: ");
	}
	
	/** showFinishMsg Usage
	 * print out finish message.
	 * 
	 * pseudo code: 
	 * 1. Print out shut down message.
	 *    
	 * Time estimate: O(1).
	 */
	public void showFinishMsg() {
		System.out.println("System shut down.");
	}
	
	/** showWelcomeMsg Usage
	 * Welcome user who log in.
	 * 
     * pseudo code: 
	 * 1. Print out welcome message.
	 *    
	 * Time estimate: O(1).
	 */
	public void showWelcomeMsg() {
		System.out.println("Welcome "+gradeSystems.getStudentName(curStudentID));
	}
	
	/** showStudentIdWrondMsg
	 * Tell user the input student ID is wrong.
	 * 
	 * pseudo code: 
	 * 1. Print out student ID wrong message.
	 *    
	 * Time estimate: O(1).
	 */
	public void showStudentIdWrongMsg() {
		System.out.println("Student ID dosen't exit in our System!");
	}
}
