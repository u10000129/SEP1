package gradeSystem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeSystemsTest {
	GradeSystems gradeSystem;
	@Before
	public void setUp() throws Exception {
		gradeSystem = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception {
		gradeSystem = null;
	}

	@Test
	public void containID1() {
		assertEquals(true, gradeSystem.containID("985002038"));
	}
	
	@Test
	public void containID2() {
		assertEquals(false, gradeSystem.containID("985102038"));
	}
	
	@Test
	public void showGrade1() {
		gradeSystem.showGrade("985002038");
	}
	
	@Test
	public void showRank1() {
		assertEquals(16, gradeSystem.showRank("985002038"));
	}
	
	@Test
	public void updateWeights1() {		
		String input = "20 20 20 20 20 Y";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    gradeSystem.updateWeights();
	}

}
