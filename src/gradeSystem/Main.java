package gradeSystem;

import java.util.Scanner;

public class Main {
	static String input;
	static UI ui = new UI();
	static Scanner scanner = new Scanner(System.in);
	
	/**IdExist Usage
	 * @return whether student ID that user input exist in system.
	 * 
	 * pseudo code: 
	 * 1. Ask ui to do checkID(input) to check whether input student ID exist in system.
	 * 2. If input student ID do exist, return true.
	 *    Otherwise, ask ui to show wrong message and return false.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input 555 (wrong student ID), print wrong message and return false.
	 */
	private static boolean IdExist() {
		if(ui.checkID(input)==false) {
			ui.showStudentIdWrongMsg();
			return false;
		}
		return true;
	}
	
	/** UserInput Usage
	 * @return 0, 1 or 2 to distinguish user input. 
	 * 
	 * 0, shut down system
	 * 1, user id wrong, re-ask user to enter ID or Quit
	 * 2, continue to Function Mode
	 * 
	 * * pseudo code: 
	 * 1. If input string equal to "Q", ask ui to show finish message and return 0.
	 *    Otherwise, if user input student ID do not exist, return 1.
	 *    Other situations return 2.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input Q, print finish message and return 0.
	 */
	private static int UserInput(){
		if(input.toUpperCase().equals("Q")) {
			ui.showFinishMsg();
			return 0;
		}
		// check whether input student ID exit in system
		else {
			// if student ID didn't exist, continue to another run
			if(IdExist()==false) return 1;
		}
		return 2;
	}
	
	/** functionMode Usage
	 * 1st, Welcome user log in system, and indicate them their are 5 different commands(G, R, A, W, E).
	 * 2nd, ask user enter command or log out.
	 * 
	 * pseudo code: 
	 * 1. Ask ui to show welcome message.
	 * 2. Use a loop to wait user to enter command (G, R, A, W or E).
	 *    If user enter E, break the loop.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input E, break the loop.
	 */
	private static void functionMode() {
		// show some welcome message
		ui.showWelcomeMsg();
		ui.promptCommand();
		// ask user to enter G, R, A, W or E
		while(true) {
			System.out.print("Please enter your command: ");
			input = scanner.nextLine();
			if(ui.checkCommand(input)==false) break;
		}
	}
	
	/**main Usage
	 * 1st, welcome user and ask them to use student ID to log in.
	 * 2nd, ask user to enter command.
	 * 
	 * pseudo code: 
	 * 1. Ask ui to show welcome message.
	 * 2. If user input Q, break the loop.
	 * 3. If user input wrong student ID, continue to re-ask user input ID or Q.
	 * 4. Else, enter function mode.
	 * 
	 * Time estimate: O(N), N for number of students.
	 * 
	 * Example: input E, break the loop and shut down whole system.
	 */
	public static void main(String[] args) {
		while(true) {
			// indicate user to enter student ID or quit System
			ui.promptID();
			input = scanner.nextLine();
			/* user enter  ID or Q */
			int InputReact = UserInput();
			if(InputReact==0) break;
			else if(InputReact==1) continue;
			/* user enter  G, R, A, W or E */
			functionMode();
		}
		//scanner.close();
	}
}
