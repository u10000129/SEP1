package gradeSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		UI ui = new UI();
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			// indicate user to enter student ID or quit System
			ui.promptID();
			input = scanner.nextLine();
			// system shut down
			if(input.toUpperCase().equals("Q"))
			{
				ui.showFinishMsg();
				break;
			}
			// check whether input student ID exit in system
			else
			{
				// if student ID didn't exist, continue to another run
				if(ui.checkID(input)==false)
				{
					ui.showStudentIdWrongMsg();
					continue;
				}
			}
			// show some welcome message
			ui.showWelcomeMsg();
			ui.promptCommand();
			while(true)
			{
				input = scanner.nextLine();
				if(ui.checkCommand(input)==false) break;
			}
		}
		scanner.close();
	}

}
