package gradeSystem;

import java.util.Scanner;

public class Main {
	static String input;
	static UI ui = new UI();
	static Scanner scanner = new Scanner(System.in);
	
	private static boolean IdExist() {
		if(ui.checkID(input)==false) {
			ui.showStudentIdWrongMsg();
			return false;
		}
		return true;
	}
	/*
	 * 0, shut down system
	 * 1, user id wrong, re-ask user to enter ID or Quit
	 * 2, continue to Function Mode
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
	
	private static void functionMode() {
		// show some welcome message
		ui.showWelcomeMsg();
		ui.promptCommand();
		// ask user to enter G, R, A, W or E
		while(true) {
			input = scanner.nextLine();
			if(ui.checkCommand(input)==false) break;
		}
	}
	
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
		scanner.close();
	}
}
