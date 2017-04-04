package junitTest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.GradeSystems;

public class GradeSystemsTest {	
	GradeSystems gradeSystem;	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		gradeSystem = new GradeSystems();
		System.setOut(new PrintStream(outContent));

	}

	@After
	public void tearDown() throws Exception {
		gradeSystem = null;
		System.setOut(null);

	}
	/**
	 * Unit test
	 * test method containID()
	 * 
	 * case1:ID "985002038"
	 * case2:ID "985102038"
	 */
	@Test
	public void containID1() {
		assertEquals(true, gradeSystem.containID("985002038"));
	}
	
	@Test
	public void containID2() {
		assertEquals(false, gradeSystem.containID("985102038"));
	}
	/**
	 * Unit test
	 * test method showGrade()
	 * 
	 * case1:ID "985002038"
	 * case2:ID "985002016"
	 */
	@Test
	public void showGrade1() {
		gradeSystem.showGrade("985002038");

		String ans = "吳德毅成績：\r\n"
		           +"           lab1          99\r\n"
		           +"           lab2          87\r\n"
		           +"           lab3          86\r\n"
		           +"           mid-term      96\r\n"
		           +"           final exam    89\r\n"
		           +"           total grade   92\r\n";				
		assertEquals(ans,outContent.toString());

	}
	
	@Test
	public void showGrade2() {
		gradeSystem.showGrade("985002016");

		String ans = "王　淳成績：\r\n"
		           +"           lab1          97\r\n"
		           +"           lab2          96\r\n"
		           +"           lab3          89\r\n"
		           +"           mid-term      85\r\n"
		           +"           final exam    80\r\n"
		           +"           total grade   86\r\n";				
		assertEquals(ans,outContent.toString());

	}
	/**
	 * Unit test
	 * test method showRank()
	 * 
	 * case1:ID "985002038"
	 * case2:ID "985002005"
	 */
	@Test
	public void showRank1() {
		assertEquals(16, gradeSystem.showRank("985002038"));
	}
	
	@Test
	public void showRank2() {
		assertEquals(31, gradeSystem.showRank("985002005"));
	}
	/**
	 * Unit test
	 * test method updateWeights()
	 * 
	 * case1:input "20 20 20 20 20 Y"
	 * case2:input "30 10 20 10 30 Y"
	 */
	@Test
	public void updateWeights1() {		
		String input = "20 20 20 20 20 Y\n"+"30 10 20 10 30 Y\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    gradeSystem.updateWeights();
	    gradeSystem.showGrade("985002029");
	    String ans = "舊配分\r\n"
	    		+"lab1                   10%\r\n"
	    		+"lab2                   10%\r\n"
	    		+"lab3                   10%\r\n"
	    		+"mid-term               30%\r\n"
	    		+"final exam             40%\r\n"
	    		+"輸入新配分\r\n"
	    		+"lab1                 lab2                 lab3                 mid-term             final exam           請確認新配分\r\n"
	    		+"lab1                   20%\r\n"
	    		+"lab2                   20%\r\n"
	    		+"lab3                   20%\r\n"
	    		+"mid-term               20%\r\n"
	    		+"final exam             20%\r\n"
	    		+"以上正確嗎? Y (Yes) 或 N (No):更新成功\r\n"
	    		+"張瑞麟成績：\r\n"
		        +"           lab1          91\r\n"
		        +"           lab2          80\r\n"
		        +"           lab3          91\r\n"
		        +"           mid-term      97\r\n"
		        +"           final exam    89\r\n"
		        +"           total grade   90\r\n";				
		assertEquals(ans,outContent.toString());
	}
	
	@Test
	public void updateWeights2() {		
		String input = "30 10 20 10 30 Y\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    gradeSystem.updateWeights();
	    gradeSystem.showGrade("975002501");
	    String ans = "舊配分\r\n"
	    		+"lab1                   10%\r\n"
	    		+"lab2                   10%\r\n"
	    		+"lab3                   10%\r\n"
	    		+"mid-term               30%\r\n"
	    		+"final exam             40%\r\n"
	    		+"輸入新配分\r\n"
	    		+"lab1                 lab2                 lab3                 mid-term             final exam           請確認新配分\r\n"
	    		+"lab1                   30%\r\n"
	    		+"lab2                   10%\r\n"
	    		+"lab3                   20%\r\n"
	    		+"mid-term               10%\r\n"
	    		+"final exam             30%\r\n"
	    		+"以上正確嗎? Y (Yes) 或 N (No):更新成功\r\n"
	    		+"張廷瑄成績：\r\n"
		        +"           lab1          80\r\n"
		        +"           lab2          86\r\n"
		        +"           lab3          98\r\n"
		        +"           mid-term      94\r\n"
		        +"           final exam    87\r\n"
		        +"           total grade   88\r\n";				
		assertEquals(ans,outContent.toString());
	}
	/**
	 * Unit test
	 * test method showAverages()
	 * 
	 * no input parameter
	 */
	@Test
	public void showAverages1() {		
	    gradeSystem.showAverages();
	    String ans = "平均成績：\r\n"
           +"           lab1          90\r\n"
           +"           lab2          87\r\n"
           +"           lab3          89\r\n"
           +"           mid-term      89\r\n"
           +"           final exam    89\r\n"
           +"           total grade   89\r\n";
	    assertEquals(ans,outContent.toString());
	}
	/**
	 * Unit test
	 * test method getStudentName()
	 * 
	 * case1: "985002040"
	 * case2: "985002003"
	 */
	@Test
	public void getStudentName1() {			    
	    String ans = "邢豪森";           
	    assertEquals(ans,gradeSystem.getStudentName("985002040"));
	}
	
	@Test
	public void getStudentName2() {			    
	    String ans = "呂映萱";           
	    assertEquals(ans,gradeSystem.getStudentName("985002003"));
	}

}
