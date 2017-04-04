package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import gradeSystem.Main;

public class IntegrationTest2 {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp(){
	}
	/**
	 * Integration Test 2
	 * test show average
	 * 
	 * Step 1: Input Student ID 955002056.
	 * Step 2: Input A to show average.
	 * Step 3: Check the correctness of the output.
	 * Step 4: Input W to change weight.
	 * Step 5: Check the correctness of the output.
	 */
	@Test
	public void integrationTest2() {		
		System.setOut(new PrintStream(outContent));
		
		String input = "955002056"
					   +"\nA"
					   +"\nW"
					   +"\n20"
					   +"\n20"
					   +"\n20"
					   +"\n20"
					   +"\n20"
					   +"\nY"
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
                     +"平均成績：\r\n"
                     +"           lab1          90\r\n"
                     +"           lab2          87\r\n"
                     +"           lab3          89\r\n"
                     +"           mid-term      89\r\n"
                     +"           final exam    89\r\n"
                     +"           total grade   89\r\n"
                     +"Please enter your command: "
                     +"舊配分\r\n"
                     +"lab1                   10%\r\n"
                     +"lab2                   10%\r\n"
                     +"lab3                   10%\r\n"
                     +"mid-term               30%\r\n"
                     +"final exam             40%\r\n"
                     +"輸入新配分\r\n"
                     +"lab1                 "
                     +"lab2                 "
                     +"lab3                 "
                     +"mid-term             "
                     +"final exam           "
                     +"請確認新配分\r\n"
                     +"lab1                   20%\r\n"
                     +"lab2                   20%\r\n"
                     +"lab3                   20%\r\n"
                     +"mid-term               20%\r\n"
                     +"final exam             20%\r\n"
                     +"以上正確嗎? Y (Yes) 或 N (No):更新成功\r\n"
                     +"Please enter your command: "
                     +"Enter 'student ID' to log in or 'Q' to quit System: "
                     +"System shut down.\r\n"
                     ;

		assertEquals(ans, outContent.toString());
		
		System.out.flush();
		System.setOut(System.out);
	}
	
}
