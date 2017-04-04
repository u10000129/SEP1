package junitTest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import gradeSystem.UI;

public class UiTest {	
	protected UI ui;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	PrintStream old = System.out;
	
	@Before
	public void setUp() throws Exception {
		ui = new UI();
	}
	/**
	 * Unit test
	 * test method checkCommand()
	 * 
	 * case1:cmd "E", return false.
	 * case2:cmd "G", return true.
	 * case3:cmd "R", return true.
	 * case4:cmd "A", return true.
	 * case5:cmd "W", return true.
	 */
	@Test
	public void test1() {
		assertEquals(false, ui.checkCommand("E"));
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void test2() {
		assertEquals(true, ui.checkCommand("G"));
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void test3() {
		assertEquals(true, ui.checkCommand("R"));
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void test4() {
		assertEquals(true, ui.checkCommand("A"));
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void test5() {
		String input = "30 10 20 10 30 Y\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    System.setOut(new PrintStream(outContent));
		assertEquals(true, ui.checkCommand("W"));
	}
	
	/**
	 * Unit test
	 * test method checkID()
	 * 
	 * case1:studentID "955002056", return true.
	 * case2:studentID "5820323144", return false; id didn't exist in grade system.
	 */
	
	@Test
	public void test6() {
		assertEquals(true, ui.checkID("955002056"));
	}
	
	@Test
	public void test7() {
		assertEquals(false, ui.checkID("5820323144"));
	}
	
	/**
	 * Unit test
	 * test method promptCommand()
	 * 
	 * case1:Check console output is the same as I expected.
	 * 
	 * Note: There is no way to have different cases.
	 */
	@Test
	public void test8() {
		System.setOut(new PrintStream(outContent));
		ui.promptCommand();
		String ans = "Support Command: 1).G - Show your grade\r\n"
					+"                 2).R - Show your rank\r\n"
					+"                 3).A - Show average grade of each exam\r\n"
					+"                 4).W - Modify weight on each exam\r\n"
					+"                 5).E - Exit Menu\r\n";
		assertEquals(ans, outContent.toString());
		System.out.flush();
		System.setOut(old);
	}
	
	/**
	 * Unit test
	 * test method promptID()
	 * 
	 * case1:Check console output is the same as I expected.
	 * 
	 * Note: There is no way to have different cases.
	 */
	@Test
	public void test9() {
		System.setOut(new PrintStream(outContent));
		ui.promptID();
		String ans = "Enter 'student ID' to log in or 'Q' to quit System: ";
		assertEquals(ans, outContent.toString());
		System.out.flush();
		System.setOut(old);
	}
	
	/**
	 * Unit test
	 * test method showFinishMsg()
	 * 
	 * case1:Check console output is the same as I expected.
	 * 
	 * Note: There is no way to have different cases.
	 */
	@Test
	public void test10() {
		System.setOut(new PrintStream(outContent));
		ui.showFinishMsg();
		String ans = "System shut down.\r\n";
		assertEquals(ans, outContent.toString());
		System.out.flush();
		System.setOut(old);
	}
	
	/**
	 * Unit test
	 * test method showWelcomeMsg()
	 * 
	 * case1:Input student id 955002056; Check console output as "Welcome ³\¤åÄÉ".
	 * case2:Input student id 962001044; Check console output as "Welcome ­â©v§Ê".
	 */
	@Test
	public void test11() {
		System.setOut(new PrintStream(outContent));
		ui.checkID("955002056");
		ui.showWelcomeMsg();
		String ans = "Welcome ³\¤åÄÉ\r\n";
		assertEquals(ans, outContent.toString());
		System.out.flush();
		System.setOut(old);
	}
	
	@Test
	public void test12() {
		System.setOut(new PrintStream(outContent));
		ui.checkID("962001044");
		ui.showWelcomeMsg();
		String ans = "Welcome ­â©v§Ê\r\n";
		assertEquals(ans, outContent.toString());
		System.out.flush();
		System.setOut(old);
	}
	
	/**
	 * Unit test
	 * test method showStudentIdWrongMsg()
	 * 
	 * case1:Check console output is the same as I expected.
	 * 
	 * Note: There is no way to have different cases.
	 */
	@Test
	public void test13() {
		System.setOut(new PrintStream(outContent));
		ui.showStudentIdWrongMsg();
		String ans = "Student ID dosen't exit in our System!\r\n";
		assertEquals(ans, outContent.toString());
		System.out.flush();
		System.setOut(old);
	}
}
