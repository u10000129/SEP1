package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import gradeSystem.Main;

public class IntegrationTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp(){
	}
	
	/**
	 * Integration Test 1
	 * test show grade and show rank
	 * 
	 * Step 1: Input Student ID 955002056.
	 * Step 2: Input G to show grade.
	 * Step 3: Check the correctness of the output.
	 * Step 4: Input R to show rank.
	 * Step 3: Check the correctness of the output.
	 */
	@Test
	public void integrationTest1() {		
		System.setOut(new PrintStream(outContent));
		
		String input = "955002056"
					   +"\nG"
					   +"\nR"
					   +"\nE"
					   +"\nQ";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
	    
		System.setIn(in);
	    Main.main(null);
	    System.setIn(System.in);
	    
	    String ans = "Enter 'student ID' to log in or 'Q' to quit System: Welcome 許文馨\r\n"
	    			 +"Support Command: 1).G - Show your grade\r\n"
	    			 +"                 2).R - Show your rank\r\n"
	    			 +"                 3).A - Show average grade of each exam\r\n"
	    			 +"                 4).W - Modify weight on each exam\r\n"
	    			 +"                 5).E - Exit Menu\r\n"
                     +"Please enter your command: "
	    			 +"許文馨成績：\r\n"
                     +"           lab1          88\r\n"
                     +"           lab2          92\r\n"
                     +"           lab3          88\r\n"
                     +"           mid-term      98\r\n"
                     +"           final exam    91\r\n"
                     +"           total grade   93\r\n"
                     +"Please enter your command: "
                     +"許文馨排名第9\r\n"
                     +"Please enter your command: "
                     +"Enter 'student ID' to log in or 'Q' to quit System: "
                     +"System shut down.\r\n"
                     ;

		assertEquals(ans, outContent.toString());
		
		System.out.flush();
		System.setOut(System.out);
	}
}
